# Surf Forecast Backend Application 

The backend for the application providing an overview of Beach Breaks in Portugal and the weather forecast for them.

## Deployment

The application is deployed on https://calm-badlands-88021.herokuapp.com/

## To run the application

Cd into the top folder of the app and run `mvn spring-boot:run`.

## Endpoints

HTTP requests should be sent to localhost:8080.

- GET: /beaches - overview of all the beaches in the database.
- GET: /beaches/{id} - find a beach by id.
- POST: /beaches - add a new beach to the database.
- PUT: /beaches/{id} - adjust beach data.
- DELETE /beaches/{id} - delete a beach from the database.

## API connection

The application is connected to the https://stormglass.io/ weather forecast API. For every beach in the database the application makes a request to the Sormglass API (with params longitute and latitude), returning waveHeight.


