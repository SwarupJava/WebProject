package com.ashokit.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.constants.AppContstants;
import com.ashokit.entity.Contact;
import com.ashokit.exception.NoDataFoundException;
import com.ashokit.props.AppProperties;
import com.ashokit.service.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactRestController {

    Logger logger = LoggerFactory.getLogger(ContactRestController.class);
	
	private ContactService contactService;
	
	private AppProperties appProps;

	public ContactRestController(ContactService contactService, AppProperties appProps) {
		this.contactService = contactService;
		this.appProps = appProps;
	}
	
	@PostMapping
	public ResponseEntity<String> saveContact(@RequestBody Contact contact){
		logger.debug("***** saveCobtact() exceution started");
		try {
		boolean isSaved = contactService.saveContact(contact);
		if(isSaved) {
			logger.info("*** saveContact() - Contact saved ***");
			
		    //String succMsg = appProps.getMessages().get("saveContactSuccess");
		    String succMsg = AppContstants.SAVE_CONSTANT_SUCCESS;
			return new ResponseEntity<>(succMsg, HttpStatus.CREATED);
		}
		}catch(Exception e) {
			logger.error("**Exception occured:**"+e.getMessage());
		}
		logger.info("*** saveContact() Contact not saved ***");
		logger.debug("***** saveCobtact() exceution ended");
		//String failMsg = appProps.getMessages().get("saveContactFailed");
		String failMsg = AppContstants.SAVE_CONSTANT_FAIL;
		return new ResponseEntity<>(failMsg, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping
	public ResponseEntity<List<Contact>> getAllContacts(){
		logger.debug("*** getAllContacts execution started ***");
		List<Contact> allContacts = null;
		try {
	    allContacts = contactService.getAllContacts();
	      if(allContacts.isEmpty()) {
	    	logger.info("*** getAllContacts() - Record is not available ***");
	      }
		}catch(Exception e) {
			logger.error("** Exception occured **"+e.getMessage());
		}
		logger.debug("*** getAllContacts - Execution ended ***");
		return new ResponseEntity<>(allContacts, HttpStatus.OK);
	}
	
	@GetMapping("/{contactId}")
	public ResponseEntity<Contact> getContactById(@PathVariable Integer contactId){
		logger.debug("*** getContactById() Excecution started ***");
		Contact contact = null;
		try {
			logger.info("*** getContactById() - No Contact Found ***");
			contact = contactService.getContactById(contactId);
			if(contact == null) {
				throw new NoDataFoundException("No Contact Found");
			}
		}catch(Exception e) {
			logger.error("Exception occured :"+e.getMessage());
		}
		logger.debug("*** getContactById() Excecution ended ***");
		return new ResponseEntity<>(contact, HttpStatus.OK);
	}
	
	@DeleteMapping("/{contactId}")
	public ResponseEntity<String> deleteContactById(@PathVariable Integer contactId){
		logger.debug("*** deleteContactById() - Execution Started ***");
		ResponseEntity<String> responseEntity = null;
		try {
			boolean isDeleted = contactService.deleteContactById(contactId);
			if(isDeleted) {
				logger.info("*** deleteContactById() - Record deleted ***");
				String succMsg = appProps.getMessages().get("deleteContactSuccess");
				//String succMsg = AppContstants.DELETE_CONSTANT_SUCCESS;
				responseEntity = new ResponseEntity<>(succMsg, HttpStatus.OK);
				return responseEntity;
			}
		}catch(Exception e) {
			logger.error("Exception occured :"+e.getMessage());
		}
		logger.debug("*** deleteContactById() - Execution ended ***");
		String failMsg = appProps.getMessages().get("deleteContactFailed");
		//String failMsg = AppContstants.DELETE_CONSTANT_FAIL;
		responseEntity = new ResponseEntity<>(failMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;
		
	}
}
