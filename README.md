# Surf Forecast Backend Application 

The backend for the application providing an overview of Beach Breaks in Portugal and the weather forecast for them.

## To run the application

Cd into the top folder of the app and run `mvn spring-boot:run`.

## Endpoints

HTTP requests should be sent to localhost:8080.

- GET: /beaches - overview of all the beaches in the database.
- GET: /beaches/{id} - find a beach by id.
- POST: /beaches - add a new beach to the database.
- DELETE /beaches/{id} - delete a beach from the database.
