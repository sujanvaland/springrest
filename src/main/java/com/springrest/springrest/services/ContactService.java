package com.springrest.springrest.services;

import com.springrest.springrest.dto.ContactDTO;
import com.springrest.springrest.entities.Contact;
import com.springrest.springrest.entities.ContactDetail;
import com.springrest.springrest.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService implements IContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    @Transactional
    public Contact saveContact(ContactDTO contactDTO) {
        Contact contact = new Contact(contactDTO.getName());

        List<ContactDetail> contactDetailsList = contactDTO.getContactDetails().stream()
                .map(detailsDTO -> new ContactDetail(detailsDTO.getEmail(), detailsDTO.getPhone(), contact))
                .collect(Collectors.toList());

        contact.setContactDetails(contactDetailsList);
        return contactRepository.save(contact);
    }

    @Transactional
    public Contact updateContact(Long id, ContactDTO contactDTO) {
        Optional<Contact> optionalContact = contactRepository.findById(id);

        if (!optionalContact.isPresent()) {
            throw new RuntimeException("Contact not found with id: " + id);
        }

        Contact existingContact = optionalContact.get();
        existingContact.setName(contactDTO.getName());

        List<ContactDetail> updatedDetailsList = contactDTO.getContactDetails().stream()
                .map(detailsDTO -> new ContactDetail(detailsDTO.getEmail(), detailsDTO.getPhone(), existingContact))
                .collect(Collectors.toList());

        existingContact.getContactDetailList().clear();
        existingContact.getContactDetailList().addAll(updatedDetailsList);

        return contactRepository.save(existingContact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
