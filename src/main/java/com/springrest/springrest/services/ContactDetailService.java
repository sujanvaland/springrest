package com.springrest.springrest.services;
import com.springrest.springrest.entities.ContactDetail;
import com.springrest.springrest.repository.ContactDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactDetailService implements  IContactDetailService {

    @Autowired
    private ContactDetailRepository contactDetailRepository;

    public List<ContactDetail> getAllContactDetails() {
        return contactDetailRepository.findAll();
    }

    public Optional<ContactDetail> getContactDetailById(Long id) {
        return contactDetailRepository.findById(id);
    }

    public ContactDetail saveContactDetail(ContactDetail contactDetail) {
        return contactDetailRepository.save(contactDetail);
    }

    public void deleteContactDetail(Long id) {
        contactDetailRepository.deleteById(id);
    }
}
