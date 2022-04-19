package com.demo.contact.web;

import com.demo.contact.domain.Address;
import com.demo.contact.domain.Contact;
import com.demo.contact.service.ContactService;
import com.demo.contact.util.ContactUtils;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Calendar;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@AutoConfigureMockMvc
public class ContactControllerTest {

	@Autowired
	private ContactService contactService;

	@Autowired
	private MockMvc mvc;

	@Before
	public void init() throws Exception {
		Contact contact = new Contact(null, "Clark Kent", "Nike", "", "clark.kent@gmail.com",
				Calendar.getInstance(), "312-333-5555", null,
				new Address(null, "1068 W Granville Ave", "22", "Rochester", "NY", "60660"));
		mvc.perform(post("/contact").content(ContactUtils.asJsonString(contact)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void listContactsTest() throws Exception {
		mvc.perform(get("/contact")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.notNullValue()))
				.andExpect(jsonPath("$[0].name", Matchers.is("Clark Kent")));
	}

	@Test
	public void addContact() throws Exception {
		Contact contact = new Contact(null, "Percy Soliz", "Nike", "", "percy.soliz.rodriguez@gmail.com",
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
		mvc.perform(put("/contact").content(ContactUtils.asJsonString(contact))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		mvc.perform(get("/contact/1")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.notNullValue()))
				.andExpect(jsonPath("$.name", Matchers.is("Peter Parker")));
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