package com.pranjaldas.healthsteps.bean;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pranjaldas.healthsteps.entity.StepsDataEntity;
import com.pranjaldas.healthsteps.entity.StepsDataIdEntity;

@Repository
public interface StepsDataBean extends JpaRepository<StepsDataEntity, StepsDataIdEntity> {

    // Native SQL query to fetch individual records
    // RANK() function assign a rank to each row within a partition of a result set.
    // rank is a reserved word hence use backticks to indicate it as a column name.
    @Query(value = """
        SELECT 
            sd.user_id AS userId,
            sd.username AS username,
            (sd.steps_count / 125) AS totalScore,
            RANK() OVER (ORDER BY (sd.steps_count / 125) DESC) AS `rank`
        FROM stepsdata sd
        WHERE steps_at = :inputDate
        ORDER BY `rank`
    """, nativeQuery = true)
    List<Object[]> getIndividualRankRecords(@Param("inputDate") Date inputDate);

    // Native SQL query to fetch team records
    @Query(value = """
        SELECT 
            sd.team_id AS teamId,
            sd.team_name AS teamName,
            SUM(sd.steps_count / 125) AS totalTeamScore,
            RANK() OVER (ORDER BY SUM(sd.steps_count / 125) DESC) AS `rank`
        FROM stepsdata sd
        WHERE steps_at = :inputDate
        GROUP BY sd.team_id, sd.team_name
        ORDER BY `rank`
    """, nativeQuery = true)
    List<Object[]> getTeamRankRecords(@Param("inputDate") Date inputDate);

    // Native SQL query to fetch min, mean and max steps
    @Query(value = """
        SELECT 
            sd.user_id AS userId,
            sd.username AS username,
            MIN(sd.steps_count) AS minSteps,
            AVG(sd.steps_count) AS meanSteps,
            MAX(sd.steps_count) AS maxSteps,
            RANK() OVER (ORDER BY username) AS `rank`
        FROM stepsdata sd
        GROUP BY sd.user_id, sd.username
        ORDER BY `rank`
    """, nativeQuery = true)
    List<Object[]> getStepStatisticsRecords();
    
}
