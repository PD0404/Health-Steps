Health Steps Challenge
Objective: Process step data and generate the following reports-
1.	Overall Individual Leaderboard
2.	Overall Team Leaderboard
3.	Step Statistics per User
4.	User Aggregate Report
Assumptions:
1.	Step Statistics is calculated based on total number of days the user takes at least 1 step.
Technologies: Java, Spring Boot, Spring JPA, RESTful APIs, MySQL, Maven.
Approach:
1.	Created a Spring Boot Application using Spring Initializr.
2.	Created a MySQL Database- HealthSteps and added two Tables- StepsData and Daily_Steps_Count.
3.	Created the Entity classes to represent the database tables.
4.	Created the DTO classes to encapsulate the output fields.
5.	Create Repository Bean classes to add queries for the desired outputs.
6.	Created Service classes to transform query results into DTOs.
7.	Created Controller class to expose an endpoint to fetch the results.
8.	Run the application- “java -jar healthsteps-0.0.1-SNAPSHOT.jar”
9.	Push the Spring Boot Application to GitHub.
10.	Deploy and Run the Application using GitHub Actions.
