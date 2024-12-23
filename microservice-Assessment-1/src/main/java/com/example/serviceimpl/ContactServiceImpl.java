package com.example.serviceimpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Repository.ContactInfoRepository;
import com.example.entity.ContactInfo;
import com.example.service.ContactInfoService;

@Service
public class ContactServiceImpl implements ContactInfoService{
	@Autowired
	private ContactInfoRepository repository;
	
	boolean flag;
	@Override
	public String addContact(ContactInfo contactInfo) {
		
		List<ContactInfo> contactList = repository.findAll();
		
		if(null != contactList) {
			for(ContactInfo contact : contactList) {
				if(contact.getFirstName().equals(contactInfo.getFirstName()))
					flag = true;
				else
					flag = false;
			}
		}
		
		if(flag) {
			return "Contact already exists";
		} else {
			repository.save(contactInfo);
			return "Contact saved";
		}
	}
}