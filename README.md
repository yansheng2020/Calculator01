# Calculator01

Geographic Distance Calculation REST Service. This REST service calculates the geographic (straight line) distance between two postcodes in the Netherlands using MySQL for storing postcode coordinates.

API Design

![image](https://github.com/yansheng2020/Calculator01/assets/68484912/af77d4b3-9009-4bcc-b5c5-8be071b97d0c)

## Prerequisites

Before building and running this service, ensure you have the following prerequisites installed:

- Java Development Kit (JDK) 17 or later
- IntelliJ IDEA
- MySQL Server

## Clone the Repository

Clone the repository to your local machine using the following command:

git clone https://github.com/yansheng2020/Calculator01.git

## Configure MySQL

1. Install and set up MySQL Server on your machine.
2. Create a database and import the postcode coordinates data.
   - Create the user connection: run query from src/resources/01_create_user.sql in MySQL root connection
   - Create schema & table, populate sample data, and set up security: run query from src/resources/02_Create_table_with_sample_data.sql in user connection crated in the last step
   - Import the data into table: import 'postcodes_coordinates_NL.csv' into the existing table - 'postcode_coordinates_three_nl'
   - Set up security: run query from src/resources/03_setup_spring_secuurity in the same user connection
   
## Open the Project in IntelliJ

1. Launch IntelliJ IDEA.
2. Select "Open" from the IntelliJ welcome screen or choose "Open" from the "File" menu.
3. Navigate to the cloned repository directory and select the project to open it.

## Configure Database Connection

1. In IntelliJ, locate the configuration file for the database connection.
2. Update the database connection details such as "spring.datasource.url", "spring.datasource.username", "spring.datasource.password"
   - This information can be found in the application.properties file.

## Build the Project

1. Open the project in IntelliJ.
2. Wait for the IDE to index and load the project dependencies.
3. Once the project is loaded, click on the "Build" menu and select "Build Project" or use the keyboard shortcut (e.g., `Ctrl + F9`).
4. IntelliJ will compile the project and generate the necessary build artifacts (.jar) in the Target folder

## Run the REST Service

1. Locate the main class for running the REST service.
2. Right-click on the main class file ("Calculator01Application") and select "Run" from the context menu.
   - Alternatively, you can create a run configuration specific to your REST service.
3. The service will start running and listen for incoming HTTP requests on port 8080 (e.g., `http://localhost:8080`).

## Usage

(1) Find a specific postcode's coordinates

To get a postcode's coordinates, send a GET request to the appropriate endpoint. Here's an example using postman:

1. Launch Postman and ensure you have it installed on your machine.
2. Set the request type to GET.
3. Enter the URL for the endpoint, replacing <host> with the appropriate hostname and <port> with the port number where your REST service is running:

GET http://localhost:8080/api/v1/postcode/postcode0
   
Replace postcode0 with the actual postcode for which you want to check.
4. Under the 'Authorization Tab', fill 'Username' with 'yansheng', fill 'Password' with 'test123'
5. Click on the "Send" button to send the GET request.
6. Postman will make the request to the specified endpoint, and you will receive a response containing
(a) The postcode id, the postcode, and the coordinates 


(2) Calculate the distance betweeen 2 postcodes in NL

To calculate the geographic straight-line distance between two postcodes, send a GET request to the appropriate endpoint. Here's an example using postman:

1. Launch Postman and ensure you have it installed on your machine.
2. Set the request type to GET.
3. Enter the URL for the endpoint, replacing <host> with the appropriate hostname and <port> with the port number where your REST service is running:

GET http://localhost:8080/api/v1/distance/postcode1/postcode2

Replace postcode1 and postcode2 with the actual postcodes for which you want to calculate the distance.

4. Under the 'Authorization Tab', fill 'Username' with 'sam', fill 'Password' with 'test123'
5. Click on the "Send" button to send the GET request.
6. Postman will make the request to the specified endpoint, and you will receive a response containing
(a) The postcode and the coordinates of both locations.
(b) The distance between the two locations in kilometers
(c) A fixed string “unit” that has the value "km"
   
   
(3) Update a specific postcode
   
To update a specific postcode coordinates, send a PUT request to the appropriate endpoint. Here's an example using postman:
   
1. Launch Postman and ensure you have it installed on your machine.
2. Set the request type to PUT.
3. Enter the URL for the endpoint, replacing <host> with the appropriate hostname and <port> with the port number where your REST service is running:

PUT http://localhost:8080/api/v1/newCoordinates

4. In the 'Body' section, select 'raw' and 'JSON', populate the 'Body' section using JSON format incl. 'postcode', 'latitude', and 'longitude'
   Ex:
   {
    "id": 1000,
    "postcode": "4255GC",
    "latitude": 51.77169805,
    "longitude": 4.920078638
   }
5. Under the 'Authorization Tab', fill 'Username' with 'susan', fill 'Password' with 'test123' 
6. Click on the "Send" button to send the PUT request.
7. Postman will make the request to the specified endpoint, and you will receive a response upon successful or failed update containing
(a) Successful update: "coordinates are successfully updated;" and the postcode and the coordinates 
(b) Filed update: "an error occurred"
   
![image](https://github.com/yansheng2020/Calculator01/assets/68484912/b198adc3-5c1e-4570-bda9-10770ee2096e)

