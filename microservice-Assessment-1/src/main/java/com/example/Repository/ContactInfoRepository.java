package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.ContactInfo;

@Repository
public interface ContactInfoRepository extends JpaRepository<ContactInfo, Integer>{
Optional<ContactInfo> findByFirstName(String contactname);
Optional<ContactInfo> findByLastName(String contactname);
Optional<ContactInfo> findByPhonenumber(String contactphonenumber);
Optional<ContactInfo> findByEmail(String contactemail);
Optional<ContactInfo> findByAddress(String contactaddress);
}