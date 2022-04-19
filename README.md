## Author
**-Name:** [Percy Soliz](https://www.linkedin.com/in/psolizrodriguez/)  
**-Email:** percy.soliz.rodriguez@gmail.com

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

## Import Project in Spring Tool Suite
1) Create directory "SpringBootService" inside of your workspace
2) Execute the following code inside of that directory once Git is installed in your machine:
```
git init  
git remote add SpringBootService https://github.com/psolizrodriguez/SpringBootService.git  
git pull SpringBootService master
```
3) Create a "Spring Starter Project" using that path
4) Run as a "Spring Boot App"

## Test Client

A pure JavaScript and JQuery client was created in order to provide a GUI and a faster way of visually testing the endpoints. The code of this client is located at the "resources/public" folder of the same project, and is currently being hosted at:  
http://localhost:8080/

## Package Structure
**-com.solstice.contact:** Contains the Spring Boot main class (Application.java) and the sample JUnit Test case (ContactControllerTest.java).  
**-com.solstice.contact.utils:** Classes for image processing.  
**-com.solstice.contact.domain:** Contains the Entities.   
**-com.solstice.contact.repository:** Contains the Repository Classes layer.  
**-com.solstice.contact.service:** Contains the Service layer.  
**-com.solstice.contact.web:** Contains the Controllers with the Restful Services.

## Data Base Connection Details
**HeidiSQL:** https://www.heidisql.com/  
**DBMS:** MySQL 5.7  
**Host:** localhost  
**Database:** demo  
**User:** demo  
**Password:** demo

## Class Diagram
![Class Diagram](https://i.imgur.com/jQ3zazu.png)

## Entity Relationship Diagram
![ERD](https://i.imgur.com/YMEcBxP.png)

## Endpoints
### 1. com.solstice.contact.web.resource.impl.ContactResourceImpl.java (contact)
#### a. List all Contacts
##### Description:
This method returns all the records of the Contact table
##### URI:
http://localhost:8080/contact
##### Parameters
```
none
```
##### Method:
GET
##### Headers:
```
Accept:application/json  
```
##### Body:
```
none
```
##### Response:
Collection of Contact type.
```
[
     {
        "contactId": 1,
        "name": "Clark Kent",
        "company": "Planet",
        "profileImage": null,
        "email": "clark.kent@gmail.com",
        "birthdate": 1511136000000,
        "personalPhoneNumber": "312-333-5555",
        "workPhoneNumber": "312-333-5554",
        "address": {
            "addressId": 20,
            "street": "Michigan Ave",
            "unit": "22",
            "city": "Rochester",
            "state": "NY",
            "zip": "60400"
        },
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/contact/1"
            },
            {
                "rel": "delete",
                "href": "http://localhost:8080/contact/1"
            },
            {
                "rel": "view",
                "href": "http://localhost:8080/contact/profilePicture/1"
            }
        ]
    }
]
```
#### b. List all Contacts by Email  (email/{email})
##### Description:
This method returns all the records of the Contact table with matching email
##### URI:
http://localhost:8080/contact/email/jane.doe
##### Parameters
**-email:** string to search on database
##### Method:
GET
##### Headers:
```
Accept:application/json  
```
##### Body:
```
none
```
##### Response:
Collection of Contact type.
```
[
    {
        "contactId": 29,
        "name": "Jane Doe",
        "company": "Nur",
        "profileImage": null,
        "email": "jane.doe",
        "birthdate": 339984000000,
        "personalPhoneNumber": "312-345-6789",
        "workPhoneNumber": "",
        "address": {
            "addressId": 30,
            "street": "Elm Street",
            "unit": "23",
            "city": "Chicago",
            "state": "IL",
            "zip": "50432"
        },
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/contact/29"
            },
            {
                "rel": "delete",
                "href": "http://localhost:8080/contact/29"
            },
            {
                "rel": "view",
                "href": "http://localhost:8080/contact/profilePicture/29"
            }
        ]
    }
]
```
#### c. List all Contacts by Phone Number  (phoneNumber/{phoneNumber})
##### Description:
This method returns all the records of the Contact table with matching personal or work phone number
##### URI:
http://localhost:8080/contact/phoneNumber/312
##### Parameters
**-phoneNumber:** string to search on database
##### Method:
GET
##### Headers:
```
Accept:application/json  
```
##### Body:
```
none
```
##### Response:
Collection of Contact type.
```
[
    {
        "contactId": 1,
        "name": "Clark Kent",
        "company": "Planet",
        "profileImage": null,
        "email": "clark.kent@gmail.com",
        "birthdate": 1511136000000,
        "personalPhoneNumber": "312-333-5555",
        "workPhoneNumber": "312-333-5554",
        "address": {
            "addressId": 20,
            "street": "Michigan Ave",
            "unit": "22",
            "city": "Rochester",
            "state": "NY",
            "zip": "60400"
        },
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/contact/1"
            },
            {
                "rel": "delete",
                "href": "http://localhost:8080/contact/1"
            },
            {
                "rel": "view",
                "href": "http://localhost:8080/contact/profilePicture/1"
            }
        ]
    }
]
```
#### d. List all Contacts by City (address/city/{city})
##### Description:
This method returns all the records of the Contact with matching city on their address
##### URI:
http://localhost:8080/contact/address/city/Chicago
##### Parameters
**-city:** string to search on database
##### Method:
GET
##### Headers:
```
Accept:application/json  
```
##### Body:
```
none
```
##### Response:
Collection of Contact type.
```
[
    {
        "contactId": 2,
        "name": "Percy Soliz",
        "company": "Solstice",
        "profileImage": null,
        "email": "percy.soliz.rodriguez@gmail.com",
        "birthdate": 1511136000000,
        "personalPhoneNumber": "312-383-8870",
        "workPhoneNumber": "312-383-8870",
        "address": {
            "addressId": 9,
            "street": "1068 W Granville Ave",
            "unit": "22",
            "city": "Chicago",
            "state": "IL",
            "zip": "60660"
        },
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/contact/2"
            },
            {
                "rel": "delete",
                "href": "http://localhost:8080/contact/2"
            },
            {
                "rel": "view",
                "href": "http://localhost:8080/contact/profilePicture/2"
            }
        ]
    }
]
```
#### e. List all Contacts by State (address/state/{state})
##### Description:
This method returns all the records of the Contact with matching state on their address
##### URI:
http://localhost:8080/contact/address/state/IL
##### Parameters
**-state:** string to search on database
##### Method:
GET
##### Headers:
```
Accept:application/json  
```
##### Body:
```
none
```
##### Response:
Collection of Contact type.
```
[
	{
        "contactId": 2,
        "name": "Percy Soliz",
        "company": "Solstice",
        "profileImage": null,
        "email": "percy.soliz.rodriguez@gmail.com",
        "birthdate": 1511136000000,
        "personalPhoneNumber": "312-383-8870",
        "workPhoneNumber": "312-383-8870",
        "address": {
            "addressId": 9,
            "street": "1068 W Granville Ave",
            "unit": "22",
            "city": "Chicago",
            "state": "IL",
            "zip": "60660"
        },
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/contact/2"
            },
            {
                "rel": "delete",
                "href": "http://localhost:8080/contact/2"
            },
            {
                "rel": "view",
                "href": "http://localhost:8080/contact/profilePicture/2"
            }
        ]
    }
]
```
#### f. Retrieve a contact record ({contactId})
##### Description:
This method returns one record corresponding the contactId sent on the URL
##### URI:
http://localhost:8080/contact/1
##### Parameters
**-contactId:** variable of type Long, referencing the contactId of the Contact to be retrieved
##### Method:
GET
##### Headers:
```
Accept:application/json  
```
##### Body:
```
none
```
##### Response:
Object of Contact type.
```
{
    "contactId": 1,
    "name": "Clark Kent",
    "company": "Planet",
    "profileImage": null,
    "email": "clark.kent@gmail.com",
    "birthdate": 1511136000000,
    "personalPhoneNumber": "312-333-5555",
    "workPhoneNumber": "312-333-5554",
    "address": {
        "addressId": 20,
        "street": "Michigan Ave",
        "unit": "22",
        "city": "Rochester",
        "state": "NY",
        "zip": "60400"
    },
    "_links": {
        "view": {
            "href": "http://localhost:8080/contact/profilePicture/1"
        },
        "save": {
            "href": "http://localhost:8080/contact"
        }
    }
}
```
#### g. Create a contact record
##### Description:
This method allows us to create a new Contact
##### URI:
http://localhost:8080/contact
##### Parameters
```
none
```
##### Method:
POST
##### Headers:
```
Accept:application/json  
Content-Type:application/json  
```
##### Body:
Object of ContactRequest type.
```
{
	"name": "Clark Kent",
    "company": "Planet",
    "profileImage": "",
    "email": "clark.kent@gmail.com",
    "birthdate": "01/01/1990",
    "personalPhoneNumber": "312-333-5555",
    "workPhoneNumber": "312-333-5554",
    "address": {
        "street": "Michigan Ave",
        "unit": "22",
        "city": "Rochester",
        "state": "NY",
        "zip": "60400"
    }
}
```
##### Response:
Object of Contact type.
```
{
    "contactId": 30,
    "name": "Clark Kent",
    "company": "Planet",
    "profileImage": null,
    "email": "clark.kent@gmail.com",
    "birthdate": 655516800000,
    "personalPhoneNumber": "312-333-5555",
    "workPhoneNumber": "312-333-5554",
    "address": {
        "addressId": 31,
        "street": "Michigan Ave",
        "unit": "22",
        "city": "Rochester",
        "state": "NY",
        "zip": "60400"
    }
}
```
#### h. Update a contact record ({contactId})
##### Description:
This method allows us to update the corresponding values of a Contact
##### URI:
http://localhost:8080/contact
##### Parameters
**-contactId:** variable of type Long, referencing the contactId of the Contact to be updated
##### Method:
PUT
##### Headers:
```
Accept:application/json  
Content-Type:application/json  
```
##### Body:
Object of ContactRequest type.
```
{
    "contactId": 30,
    "name": "Clark Kent",
    "company": "Daily Planet",
    "profileImage": null,
    "email": "clark.kent@gmail.com",
    "birthdate": "2010-10-10",
    "personalPhoneNumber": "312-333-5555",
    "workPhoneNumber": "312-333-5554",
    "address": {
        "addressId": 31,
        "street": "Michigan Ave",
        "unit": "22",
        "city": "Rochester",
        "state": "NY",
        "zip": "60400"
    }
}
```
##### Response:
```
Ok: 200
```
#### i. Delete a contact record ({contactId})
##### Description:
This method allows us to delete a Contact
##### URI:
http://localhost:8080/contact/31
##### Parameters
**-contactId:** variable of type Long, referencing the contactId of the Contact to be deleted
##### Method:
DELETE
##### Headers:
```
Accept:application/json   
```
##### Body:
```
none
```
##### Response:
```
Ok: 200
```
#### j. Retrieve a Profile Picture (profilePicture/{contactId})
##### Description:
This method returns the profile picture corresponding to the contactId sent as a parameter
##### URI:
http://localhost:8080/contact/profilePicture/1
##### Parameters
**-contactId:** variable of type Long, referencing the contactId of the Profile Image to be retrieved
##### Method:
GET
##### Headers:
```
Accept:application/json  
```
##### Body:
```
none
```
##### Response:
Object of MediaType.IMAGE_JPEG_VALUE type.
```
JPEG File
```
## JUnit Test Cases
### com.solstice.contact.web.resource.test.ContactResourceImplTest.java
```
package com.solstice.contact;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.solstice.contact.domain.Address;
import com.solstice.contact.domain.Contact;
import com.solstice.contact.service.ContactService;
import com.solstice.contact.util.ContactUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContactControllerTest {

	@Autowired
	private ContactService contactService;

	@Autowired
	private MockMvc mvc;

	@Test
	public void listContactsTest() throws Exception {
		mvc.perform(get("/contact")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.notNullValue()))
				.andExpect(jsonPath("$[0].name", Matchers.is("Clark Kent")));
	}

	@Test
	public void addContact() throws Exception {
		Contact contact = new Contact(null, "Percy Soliz", "Solstice", "", "percy.soliz.rodriguez@gmail.com",
				Calendar.getInstance(), "312-383-8870", null,
				new Address(null, "1068 W Granville Ave", "22", "Chicago", "IL", "60660"));
		mvc.perform(post("/contact").content(ContactUtils.asJsonString(contact)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.name", Matchers.is("Percy Soliz")));
	}

	@Test
	public void getContactById() throws Exception {
		mvc.perform(get("/contact/1")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.notNullValue()))
				.andExpect(jsonPath("$.name", Matchers.is("Clark Kent")));
	}

	@Test
	public void deleteContactTest() throws Exception {
		mvc.perform(delete("/contact/31")).andExpect(status().isBadRequest());
	}

	@Test
	public void updateContact() throws Exception {
		Contact contact = contactService.getContactById(1L);
		contact.setName("Peter Parker");
		mvc.perform(get("/contact/1").content(ContactUtils.asJsonString(contact))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void listContactsByEmail() throws Exception {
		mvc.perform(get("/contact/email/gmail")).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.notNullValue()))
				.andExpect(jsonPath("$[0].email", Matchers.is("clark.kent@gmail.com")));
	}
	
	@Test
	public void listContactsByPhoneNumber() throws Exception {
		mvc.perform(get("/contact/phoneNumber/312-333")).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.notNullValue()))
				.andExpect(jsonPath("$[0].personalPhoneNumber", Matchers.is("312-333-5555")));
	}
	
	@Test
	public void listContactsByCity() throws Exception {
		mvc.perform(get("/contact/address/city/Rochester")).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.notNullValue()))
				.andExpect(jsonPath("$[0].address.city", Matchers.is("Rochester")));
	}
	
	@Test
	public void listContactsByState() throws Exception {
		mvc.perform(get("/contact/address/state/NY")).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.notNullValue()))
				.andExpect(jsonPath("$[0].address.state", Matchers.is("NY")));
	}

}
```