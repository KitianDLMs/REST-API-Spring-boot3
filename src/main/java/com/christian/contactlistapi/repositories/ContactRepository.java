package com.christian.contactlistapi.repositories;

import com.christian.contactlistapi.entity.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

}
