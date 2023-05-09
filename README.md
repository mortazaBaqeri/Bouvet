# Note app

This application is made for my interview at Bouvet.
The application is created using Java 20 and Spring.

The application does not have front-end.

## How to run the application
 - Have docker installed and running.
- Start the postgreSQL container: 
    - Open a terminal instance
    - In project folder, (Bouvet) run command: **docker compose up.**
    

- Start spring application
    - If you get error: FATAL: database "note" does not exist
    - Connect to the database trough terminal and create database note:
        - Open terminal, run command: docker ps
        - Run command: docker exec -it "postgres CONTAINER ID" bash
        - Run command: psql -U amigoscode 
        - Run command: CREATE DATABASE note;
        - Run command: \l
            - If everything is ok, database "note" will be in the list of databases 
- Use your favorite api testing tool and test the note application by using the routes below

## Routes
- POST - Create note: localhost:8080/notes/store
- GET - Get a single note: localhost:8080/notes/{id}
- GET - Get all notes: localhost:8080/notes/
- PUT - localhost:8080/notes/{id}
- DELETE - localhost:8080/notes/{id}


### Acknowledgments
This application was developed with the assistance of: 
- [Spring Boot - Learn Spring Boot 3 (2 Hours)](https://www.youtube.com/watch?v=-mwpoE0x0JQ).
- [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
