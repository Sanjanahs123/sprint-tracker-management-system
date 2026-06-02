Sprint Tracker Management System
1.Overview
The Sprint Tracker Management System is a Spring Boot REST API designed to manage clients, projects, sprints, engineers, and tasks in an Agile software development environment.
The system provides CRUD operations, validation, exception handling, and business intelligence APIs to track sprint progress, engineer workload, project health, and task management.

2.Tech Stack
  -Java 17
  -Spring Boot
  -Spring Data JPA
  -Hibernate
  -MySQL
  -Maven
  -Postman

3.Entity Relationships
 -Client → Project → Sprint → Task
 -Engineer → Task
 -A client can have multiple projects.
 -A project can have multiple sprints.
 -A sprint can have multiple tasks.
 -An engineer can be assigned multiple tasks.

4.Features Implemented
  a)CRUD APIs
   -Client Management
   -Project Management
   -Sprint Management
   -Engineer Management
   -Task Management
   
  b)Validation & Exception Handling
   -Bean Validation using @NotBlank, @NotNull, and @Email
   -Global Exception Handling using @RestControllerAdvice
   -ResourceNotFoundException
   -EngineerNotAvailableException
   -InvalidStatusTransitionException

  c)Business Rules
   -Engineers marked unavailable cannot be assigned to tasks.
   -Task status progression is restricted:
       TODO → IN_PROGRESS → REVIEW → DONE
       Backward transitions are rejected.

5.Sprint Intelligence APIs
 a)Sprint Summary
   -GET /api/sprints/{id}/summary
   -Returns:
     Total tasks
     Completed tasks
     Completion percentage
     Tasks grouped by priority
     Overdue task count

  b)Engineer Workload
   -GET /api/engineers/{id}/workload
   -Returns:
     Active task count
     Tasks grouped by status
     Estimated vs actual hours

  c)Project Health
    -GET /api/projects/{id}/health
    -Health Score Formula:
      Health Score = Completion Rate − (Overdue Tasks × 10)
      Status Classification:
          GOOD (80–100)
          AVERAGE (50–79)
          POOR (<50)

  d)Available Engineers
    -GET /api/engineers/available?stack=JAVA
    -Returns available engineers with fewer than 3 active tasks.

  e)Task Filtering
    -GET /api/tasks/filter
    -Supports filtering by:
      Status
      Priority
      Sprint ID

6.Design Decisions
-DTOs were used to separate API contracts from entities.
-Service layer contains business logic.
-Repository layer handles database access.
-Global exception handling provides consistent API responses.
-Business rules were implemented in the service layer to keep controllers lightweight.

7.Author
 Sanjana H S
 B.E. Information Science & Engineering
 CMR Institute of Technology
