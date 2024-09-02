package com.springrest.springrest.services;

import com.springrest.springrest.dto.ContactDTO;
import com.springrest.springrest.entities.Contact;

import java.util.List;
import java.util.Optional;

public interface IContactService {
    List<Contact> getAllContacts();
    Optional<Contact> getContactById(Long id);
    Contact saveContact(ContactDTO contact);
    Contact updateContact(Long id, ContactDTO contactDTO);
    void deleteContact(Long id);
}
