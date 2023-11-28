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
 