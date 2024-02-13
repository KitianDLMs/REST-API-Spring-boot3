package com.christian.contactlistapi.controller;

import com.christian.contactlistapi.dto.ContactDTO;
import com.christian.contactlistapi.entity.Contact;
import com.christian.contactlistapi.service.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/contacts")
@RestController
public class ContactController {

    private final ContactService contactService;

    @GetMapping()
    public Iterable<Contact> list() {
        return contactService.findAll();
    }
    @GetMapping("{id}")
    public Contact get(@PathVariable Integer id) {
        return contactService.findById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Contact create(@Validated @RequestBody ContactDTO contactDTO) {
        return contactService.create(contactDTO);
    }

    @PutMapping("{id}")
    public Contact update(@PathVariable Integer id,
                          @Validated @RequestBody ContactDTO contactDTO) {
        return contactService.update(id, contactDTO);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        contactService.delete(id);
    }
}
