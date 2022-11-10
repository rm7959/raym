### Running the project
The application uses [Spring Boot](http://projects.spring.io/spring-boot/), so it is easy to run. You can start it any of a few ways:

* Run the `main` method from `FlightsServiceApplication`
* Use the Gradle Spring Boot plugin: `gradlew bootRun`
* Package the application as a JAR and run it using `java -jar flights-service-0.0.1-SNAPSHOTS.jar`
* Viewing the running application
* To view the running application, visit http://localhost:8080 in your browser

### Testing the project
* There is no data initially in the H2 database so you can add some data
* To add flights data use `POST http://localhost:8080/v1/flights` with body like
```json
{
    "flightNumber": "QF400",
    "departurePort": "MEL",
    "arrivalPort": "SYD",
    "departureTime": "2020-06-10T09:00:23Z",
    "arrivalTime": "2020-06-10T10:25:23Z"
}
```
* To get all flights use `GET http://localhost:8080/v1/flights`
```json
{
    "flights": [
        {
            "flightNumber": "QF401",
            "departurePort": "MEL",
            "arrivalPort": "SYD",
            "departureTime": "2020-06-10T09:00:23",
            "arrivalTime": "2020-06-10T10:25:23"
        },
        {
            "flightNumber": "QF400",
            "departurePort": "MEL",
            "arrivalPort": "SYD",
            "departureTime": "2020-06-10T08:00:23",
            "arrivalTime": "2020-06-10T09:25:23"
        },
        {
            "flightNumber": "EK500",
            "departurePort": "MEL",
            "arrivalPort": "SYD",
            "departureTime": "2020-06-10T08:00:23",
            "arrivalTime": "2020-06-10T09:25:23"
        }
    ]
}
```
* To get all flights by Airline Code `To get all flights `http://localhost:8080/v1/flights?airlineCode=QF`
```json
{
    "flights": [
        {
            "flightNumber": "QF401",
            "departurePort": "MEL",
            "arrivalPort": "SYD",
            "departureTime": "2020-06-10T09:00:23",
            "arrivalTime": "2020-06-10T10:25:23"
        },
        {
            "flightNumber": "QF400",
            "departurePort": "MEL",
            "arrivalPort": "SYD",
            "departureTime": "2020-06-10T08:00:23",
            "arrivalTime": "2020-06-10T09:25:23"
        }
    ]
}
```