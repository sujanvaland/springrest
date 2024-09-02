package com.springrest.springrest.repository;

import com.springrest.springrest.entities.ContactDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactDetailRepository extends JpaRepository<ContactDetail, Long> {
}
