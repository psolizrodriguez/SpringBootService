package com.demo.contact.repository;

import java.util.List;

import com.demo.contact.domain.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	List<Contact> listContactsByEmail(@Param("email") String email);

	List<Contact> listContactsByPhoneNumber(@Param("phoneNumber") String phoneNumber);

	List<Contact> listContactsByCity(@Param("city") String city);

	List<Contact> listContactsByState(@Param("state") String state);

}
