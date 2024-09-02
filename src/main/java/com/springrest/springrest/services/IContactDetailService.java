package com.springrest.springrest.services;

import com.springrest.springrest.entities.ContactDetail;

import java.util.List;
import java.util.Optional;

public interface IContactDetailService {
    List<ContactDetail> getAllContactDetails();
    Optional<ContactDetail> getContactDetailById(Long id);
    ContactDetail saveContactDetail(ContactDetail contactDetail);
    void deleteContactDetail(Long id);
}
