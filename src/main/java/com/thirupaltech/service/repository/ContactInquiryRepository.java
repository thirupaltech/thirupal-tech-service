package com.thirupaltech.service.repository;

import com.thirupaltech.service.entity.ContactInquiry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactInquiryRepository extends JpaRepository<ContactInquiry, UUID> {
}
