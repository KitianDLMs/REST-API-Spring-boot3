package com.christian.contactlistapi.service;

import com.christian.contactlistapi.dto.ContactDTO;
import com.christian.contactlistapi.entity.Contact;
import com.christian.contactlistapi.exception.ResourceNotFoundException;
import com.christian.contactlistapi.repositories.ContactRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper mapper;

    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Integer id) {
        return contactRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Contact create(ContactDTO contactDTO) {
        Contact contact = mapper.map(contactDTO, Contact.class);
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, ContactDTO contactDTO) {
        Contact contactFromDB = findById(id);

        mapper.map(contactDTO, contactFromDB);
        return contactRepository.save(contactFromDB);
    }

    public void delete(Integer id) {
        Contact contactFromDB = contactRepository
                .findById(id)
                .orElse(null);
        contactRepository.delete(contactFromDB);
    }

}