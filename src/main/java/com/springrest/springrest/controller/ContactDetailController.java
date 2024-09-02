package com.springrest.springrest.controller;
import com.springrest.springrest.entities.ContactDetail;
import com.springrest.springrest.services.IContactDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contactDetails")
public class ContactDetailController {

    @Autowired
    private IContactDetailService contactDetailService;

    @GetMapping
    public List<ContactDetail> getAllContactDetails() {
        return contactDetailService.getAllContactDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactDetail> getContactDetailById(@PathVariable Long id) {
        return contactDetailService.getContactDetailById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ContactDetail createContactDetail(@RequestBody ContactDetail contactDetail) {
        return contactDetailService.saveContactDetail(contactDetail);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDetail> updateContactDetail(@PathVariable Long id, @RequestBody ContactDetail updatedContactDetail) {
        return contactDetailService.getContactDetailById(id)
                .map(contactDetail -> {
                    contactDetail.setPhone(updatedContactDetail.getPhone());
                    contactDetail.setEmail(updatedContactDetail.getEmail());
                    return ResponseEntity.ok(contactDetailService.saveContactDetail(contactDetail));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContactDetail(@PathVariable Long id) {
        if (contactDetailService.getContactDetailById(id).isPresent()) {
            contactDetailService.deleteContactDetail(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
