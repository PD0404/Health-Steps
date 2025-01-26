package com.pranjaldas.healthsteps.bean;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pranjaldas.healthsteps.entity.DailyStepsCountEntity;
import com.pranjaldas.healthsteps.entity.StepsDataIdEntity;

@Repository
public interface DailyStepsCountBean extends JpaRepository<DailyStepsCountEntity, StepsDataIdEntity> {
        
    // Native SQL query to fetch user daily steps count
    @Query(value = """
        SELECT 
            sc.user_id AS userId,
            COUNT(*) AS totalDays,
            COUNT(CASE WHEN sc.steps_count > 8000 THEN 1 END) AS daysInGold,
            COUNT(CASE WHEN sc.steps_count > 4000 AND sc.steps_count < 8000 THEN 1 END) AS daysInSilver,
            COUNT(CASE WHEN sc.steps_count < 4000 THEN 1 END) AS daysInBronze,
            CASE 
                WHEN COUNT(*) > 0 THEN ROUND((COUNT(CASE WHEN sc.steps_count > 8000 THEN 1 END) * 100.0) / COUNT(*), 2)
                ELSE 0
            END AS percentageInGold,
            CASE 
                WHEN COUNT(*) > 0 THEN ROUND((COUNT(CASE WHEN sc.steps_count > 4000 AND sc.steps_count < 8000 THEN 1 END) * 100.0) / COUNT(*), 2)
                ELSE 0
            END AS percentageInSilver,
            CASE 
                WHEN COUNT(*) > 0 THEN ROUND((COUNT(CASE WHEN sc.steps_count < 4000 THEN 1 END) * 100.0) / COUNT(*), 2)
                ELSE 0
            END AS percentageInBronze,
            CASE
                WHEN COUNT(CASE WHEN sc.steps_count > 8000 THEN 1 END) >= 
                    GREATEST(COUNT(CASE WHEN sc.steps_count BETWEEN 5001 AND 8000 THEN 1 END), 
                            COUNT(CASE WHEN sc.steps_count <= 5000 THEN 1 END)) THEN 'Gold'
                WHEN COUNT(CASE WHEN sc.steps_count BETWEEN 5001 AND 8000 THEN 1 END) >= 
                    GREATEST(COUNT(CASE WHEN sc.steps_count > 8000 THEN 1 END), 
                            COUNT(CASE WHEN sc.steps_count <= 5000 THEN 1 END)) THEN 'Silver'
                ELSE 'Bronze'
            END AS primaryLeague
        FROM daily_steps_count sc
        WHERE sc.steps_at >= :dateRangeStart AND sc.steps_at <= :dateRangeEnd
        GROUP BY sc.user_id
    """, nativeQuery = true)
    List<Object[]> getUserReportRecords(@Param("dateRangeStart") Date dateRangeStart, @Param("dateRangeEnd") Date dateRangeEnd);

}
