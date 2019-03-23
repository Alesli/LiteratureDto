# LiteratureDto

## Project description.

***This project demonstrates usage of Java technologies to create console application.***
The application displays the result of the queries in the console: authors/books in any variation.
Converter and DTO layer added to project. `Converter` is an interface describing a Java class that can perform Object-to-String and String-to-Object conversions between model data objects and those objects that is suitable for rendering.
`DTO` is an object that transfers data between processes to reduce the number of method calls.
Added `CRUD Concept Application` (Create, Read, Update, Delete), tested on `Mysql`, version 5.1.47.
 ***
## Technologies used in the project:
- `Java core`, jdk 1.8
- `POJO`
- `DAO` (Data Access Object)
- `DTO`(Data Transfer Object Design Pattern in Java)
- `Facade Design pattern` (Intermediate layer for business logic, can be used to integrate data for multiple sources)
- Tools: git, maven
- Database: `Mysql`, version 5.1.47
- `JDBC` (Java DataBase Connectivity)
- Property package with `CRUD Concept Application` (Create, Read, Update, Delete)
- `Lombok`, version 1.18.2
 ***
## Installation instructions:
- Clone repository
- Run mvn **clean install**
- Used database server - **mysql**
- Driver - **com.mysql.jdbc.Driver**
- Url - <jdbc:mysql://localhost:3306/literature_first?useSSL=false&createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf-8&characterSetResults=utf-8&autoReconnect=true>
- Run the script to create a database