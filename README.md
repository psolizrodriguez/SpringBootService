# Coding Challenge for Nearsure 

## Scope
Develop a RESTful API that would allow a web or mobile front-end to:  
-Create a contact record  
-Retrieve a contact record  
-Update a contact record  
-Delete a contact record  
-Search for a record by email or phone number  
-Retrieve all records from the same state or city  
The contact record should represent the following information: name, company, profile image, email, birthdate, phone number (work, personal) and address .  
Also please provide a unit test for at least one of the endpoints you create.

## How to run
1) Open the project with your preferred IDE (Strongly suggest using IntelliJ IDE).
2) Create the **demo** schema in your local MySQL server. (MySQL v5.5 is recommended)
3) Add a demo user with **demo** and password **password** and grant all permissions to your **demo** database
4) Create the folder **/opt/img** and grant read and write permissions
5) Run Application class
6) Access the UI at [http://localhost:8080](http://localhost:8080)

## Package Structure
**-com.demo.contact:** Contains the Spring Boot main class (Application.java) and the sample JUnit Test case (ContactControllerTest.java).  
**-com.demo.contact.utils:** Classes for image processing.  
**-com.demo.contact.domain:** Contains the Entities.   
**-com.demo.contact.repository:** Contains the Repository Classes layer.  
**-com.demo.contact.service:** Contains the Service layer.  
**-com.demo.contact.web:** Contains the Controllers with the Restful Services.

## Class Diagram  
![Class Diagram](https://i.imgur.com/jQ3zazu.png)  

## Entity Relationship Diagram  
![ERD](https://i.imgur.com/YMEcBxP.png)