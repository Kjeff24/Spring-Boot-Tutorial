# SPRING-BOOT TUTORIAL

## DESCRIPTION
Exploring the foundational architecture of Spring Boot, we employed PostgreSQL as the database, interacting with it through the use of JdbcTemplate. 
To configure the database connection, navigate to the application.yml file and provide the necessary password for your PostgreSQL instance.

## FOLDER STRUCTURE
```
src/
|-- main/
|   |-- java/
|   |   |-- com/
|   |       |-- yourcompany/
|   |           |-- yourapp/
|   |               |-- api/     # to handle HTTP requests and defines endpoints
|   |               |   |-- ApiController.java
|   |               |
|   |               |-- dao/            # to handle data operations
|   |               |   |-- YourEntityDao.java
|   |               |   |-- impl/       // Implementation of EntityDao interface.
|   |               |       |-- YourEntityDaoImpl.java
|   |               |
|   |               |-- model/          # to define your data model
|   |               |   |-- YourEntity.java
|   |               |
|   |               |-- service/        # to handle business logic
|   |               |   |-- HelloService.java
|   |               |   |-- impl/       // Implementation of Service interface.
|   |               |       |-- HelloServiceImpl.java
|   |               |
|   |               |-- YourApplication.java    # main application 
|   |
|   |-- resources
|       |-- application.properties

```

 NB: In a typical Java or Spring project structure, the dao/ and service/ folders often follow an interface and implementation separation pattern. Here's a breakdown:
1. `dao`/ and `service`/ folders:
These folders typically contain interfaces that define the contract (method signatures) for data access operations or business logic.

2. `impl/` subfolder:
The `impl/` subfolder under `dao/` and `service/` contains the implementation classes that provide concrete functionality for the interfaces declared in the parent folders.


 ### Relationship
1. Controller Layer (`controller`):
Controllers handle HTTP requests and define API endpoints.
They interact with the Service layer to perform business logic.
Controllers may utilize Data Access Objects (DAOs) to retrieve or manipulate data.

2. Service Layer (`service`):
Services contain business logic and act as an intermediary between controllers and DAOs.
They interact with the DAO layer for data access.
Services may use models/entities to represent data.

3. Data Access Object Layer (`dao`):
DAOs define interfaces for data access operations (e.g., CRUD operations).
They may be implemented by classes in the impl subfolder.
DAOs interact with the underlying data store (e.g., a database) to perform data access.

4. Model Layer (`model`):
Models represent the data entities of the application.
Models are often used by both the Service and DAO layers.
Models define the structure of the data in the application.

5. Application Entry Point (`YourApplication.java`):
YourApplication.java serves as the main class and entry point of the Spring Boot application.
It initializes the Spring context and starts the application.

6. Testing (`test`):
The test folder contains test classes that mirror the structure of the main application.
Test classes in controller, service, and dao test the corresponding components.
Testing ensures that each layer and component behaves as expected.

7. Configuration and Resources (`resources`):
The resources folder contains configuration files such as application.properties.
Configuration files provide settings for the application, such as database connection details.

In summary, the controller delegates data retrieval to a service. The service then uses a DAO to retrieve the data from the database, and the retrieved data is packaged into a model that the service passes back to the controller. The controller then sends the model to the view for rendering.

User Request --> Controller --> Service --> DAO --> Database

NB: Read on Inversion of Control and Dependency Injection

# MAVEN
## mvnw [default]
1. compile - compiles your code into bytecode.
2. test - Runs unit tests.
3. package - Creates a jar or war file.
4. verify - Runs check & integration tests.

## Maven Workflow
1. .\mvnw clean compile
2. .\mvnw clean test
3. .\mvnw clean package
4. .\mvnw clean verify

## Run jar file
``` 
java -jar filename.jar 
```

## Run spring boot project
``` 
.\mvnw spring-boot:run
```

## Spring App Layer
<ul>
<li>Presentation (Controllers): Take all of the data as a result of using the service layer, then present to the user through APIs</li>
<li>Service: Use all the functionalities by the Persistence layer to meet the requirements the application is being built to handle.</li>
<li>Persistence: Handle interactions with database using entities
<ol>
<li>Repositories</li>
<li>Data Access Objects (DAOs)</li>
</ol>
</li>
</ul>