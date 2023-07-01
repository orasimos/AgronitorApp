# AgronitorApp
Agronitor is a web application that allows users to monitor and manage greenhouses. 
It displays data on temperature, humidity, soil hydration, and UV radiation levels within the greenhouses.

## Features
- View measurements of temperature, humidity, soil hydration, and UV radiation.
- Set minimum and maximum thresholds for each measurement.
- Manage multiple greenhouses and their associated measurements.
- Basic user registration functionality.
- Basic user authentication functionality.

## Upcoming features
- User authentication and authorization for secure access.
- Receive notifications when measurement values exceed the defined thresholds.
- Visual represantation of data with graphs to help the user visualize the fluctuations of each greenhouse's measurements in specidied time periods.

## Technologies Used
- Java
- Spring Boot
- MySQL
- Tomcat
- Android
- Swagger

## API Documentation
The api documentation can be found at: http://localhost:8080/swagger-ui/index.html

## Disclaimer
- The android app is optimized for the pixel 6.
- Currently the app uses an internal script to update the measurements of each greenhouse in 30 minute intervals.
The ultimate goal of the app is to use an arduino with temperature, humidity, soil hydration and uv radiation sensors to post real-time measuremnets to the database.

## Getting Started

### Prerequisites
- Java Developement Kit (JDK) 11 or higher
- MySQL
- Android Software Developement Kit (SDK) 24 or higher
- Tomcat 9.0

### Installation
1. Clone the repository: https://github.com/orasimos/AgronitorApp.git

2. Create the MySQL database using the script 'agrinitor_testdb.sql'.

3. Make sure to create a user as owner for the database and input the credentials in the 'application.properties' of 'agronitor_backend'

3. Run 'agronitor_backend' from your IDE.

4. While 'agronitor_backend' is running you can start the Android App.

6. In the app register a new user or test one of the already existing users by logging in with their credentials:
    "orasimos": "orasimos1234"
    "test_user": "test_user1234"

7. Because of the use of the internal script that updates the measurements it is recommended to restart 'agronitor_backend' after creating a new greenhouse,
    otherwise there will be no measurements to display.
