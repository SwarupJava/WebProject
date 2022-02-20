package com.ashokit.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.ashokit.entity.Contact;
import com.ashokit.props.AppProperties;
import com.ashokit.service.ContactService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@WebMvcTest(value=ContactRestController.class)
public class ContactRestControllerTest {

	@MockBean
	private ContactService service;
	
	@MockBean
	private AppProperties props;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void test_saveContact_1() {
        when(service.saveContact(Mockito.any())).thenReturn(true);
        
        Contact c = new Contact(101,"Ashok","ashokitschool@gmail.com","9872546321");
        ObjectMapper mapper = new ObjectMapper();
        String json=null;
		try {
			json = mapper.writeValueAsString(c);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        MockHttpServletRequestBuilder reqBuilders = MockMvcRequestBuilders.post("/api/contact")
        		                                                   .contentType("application/json")
        		                                                   .content(json);
        
        MvcResult mvcResult=null;
		try {
        mvcResult = mockMvc.perform(reqBuilders).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		     e.printStackTrace();
	    }
        MockHttpServletResponse response =  mvcResult.getResponse();
        int status = response.getStatus();
        assertEquals(201, status);
	}
	
	@Test
	public void test_saveContact_2() {
        when(service.saveContact(Mockito.any())).thenReturn(false);
        
        Contact c = new Contact(101,"Ashok","ashokitschool@gmail.com","9872546321");
        ObjectMapper mapper = new ObjectMapper();
        String json=null;
		try {
			json = mapper.writeValueAsString(c);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        MockHttpServletRequestBuilder reqBuilders = MockMvcRequestBuilders.post("/api/contact")
        		                                                   .contentType("application/json")
        		                                                   .content(json);
        
        MvcResult mvcResult=null;
		try {
        mvcResult = mockMvc.perform(reqBuilders).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		     e.printStackTrace();
	    }
        MockHttpServletResponse response =  mvcResult.getResponse();
        int status = response.getStatus();
        assertEquals(500, status);
	}
	
	@Test
	public void test_saveContact_3() throws Exception{
        when(service.saveContact(Mockito.any())).thenThrow(RuntimeException.class);
        
        Contact c = new Contact(101,"Ashok","ashokitschool@gmail.com","9872546321");
        ObjectMapper mapper = new ObjectMapper();
        String json=null;
		try {
			json = mapper.writeValueAsString(c);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        MockHttpServletRequestBuilder reqBuilders = MockMvcRequestBuilders.post("/api/contact")
        		                                                   .contentType("application/json")
        		                                                   .content(json);
        
        MvcResult mvcResult=null;
		try {
        mvcResult = mockMvc.perform(reqBuilders).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		     e.printStackTrace();
	    }
        MockHttpServletResponse response =  mvcResult.getResponse();
        int status = response.getStatus();
        assertEquals(500, status);
	}
	
	@Test
	public void getAllContacts_test_1() throws Exception{
		when(service.getAllContacts()).thenReturn(Collections.emptyList());
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/api/contact");
		MvcResult mvcResult = null;
		try {
			mvcResult = mockMvc.perform(reqBuilder).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}
	
	@Test
	public void getAllContacts_test_2() throws Exception{
		when(service.getAllContacts()).thenThrow(RuntimeException.class);
		MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/api/contact");
		MvcResult mvcResult = null;
		try {
			mvcResult = mockMvc.perform(reqBuilder).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
	}
	  
	  @Test 
	  public void getContactById_test_1() throws Exception{ 
		  Contact c = new Contact(101,"Ashok","ashokitschool@gmail.com","9872546321");
	      when(service.getContactById(101)).thenReturn(c);
	  
	      MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/api/contact/101"); 
	      MvcResult mvcResult = null;
	      try { 
	    	  mvcResult = mockMvc.perform(reqBuilder).andReturn(); 
	    	  } catch (Exception e) { 
	    		  // TODO Auto-generated catch block 
	    		  e.printStackTrace();
	    	  }
	  MockHttpServletResponse response = mvcResult.getResponse();
	  int status = response.getStatus(); 
	  assertEquals(200, status); 
	  }
	  
	  @Test 
	  public void getContactById_test_2() throws Exception{ 
		  Contact c = new Contact(101,"Ashok","ashokitschool@gmail.com","9872546321");
	      when(service.getContactById(101)).thenReturn(null);
	  
	      MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.get("/api/contact/101"); 
	      MvcResult mvcResult = null;
	      try { 
	    	  mvcResult = mockMvc.perform(reqBuilder).andReturn(); 
	    	  } catch (Exception e) { 
	    		  // TODO Auto-generated catch block 
	    		  e.printStackTrace();
	    	  }
	     
	  
	  MockHttpServletResponse response = mvcResult.getResponse();
	  int status = response.getStatus(); 
	  assertEquals(200, status); 
	  }
	  
	  @Test 
	  public void deleteContactById_test_1() throws Exception{ 
		  //Contact c = new Contact(101,"Ashok","ashokitschool@gmail.com","9872546321");
	      when(service.deleteContactById(101)).thenReturn(true);
	      MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.delete("/api/contact/101");
	      MvcResult mvcResult = null;
	      try { 
	    	  mvcResult = mockMvc.perform(reqBuilder).andReturn(); 
	    	  } catch (Exception e) { 
	    		  // TODO Auto-generated catch block 
	    		  e.printStackTrace();
	    	  }
	  MockHttpServletResponse response = mvcResult.getResponse();
	  int status = response.getStatus(); 
	  assertEquals(200, status); 
	  }
	  
	  @Test 
	  public void deleteContactById_test_2() throws Exception{ 
		  //Contact c = new Contact(101,"Ashok","ashokitschool@gmail.com","9872546321");
	      when(service.deleteContactById(101)).thenReturn(false);
	      MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.delete("/api/contact/101"); 
	      MvcResult mvcResult = null;
	      try { 
	    	  mvcResult = mockMvc.perform(reqBuilder).andReturn(); 
	    	  } catch (Exception e) { 
	    		  // TODO Auto-generated catch block 
	    		  e.printStackTrace();
	    	  }
	  MockHttpServletResponse response = mvcResult.getResponse();
	  int status = response.getStatus(); 
	  assertEquals(500, status); 
	  }
	  
	  @Test
		public void deleteContactById_test_3() throws Exception{
			when(service.deleteContactById(101)).thenThrow(RuntimeException.class);
			MockHttpServletRequestBuilder reqBuilder = MockMvcRequestBuilders.delete("/api/contact/101");
			MvcResult mvcResult = null;
			try {
				mvcResult = mockMvc.perform(reqBuilder).andReturn();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MockHttpServletResponse response = mvcResult.getResponse();
			int status = response.getStatus();
			assertEquals(500, status);
		}
	  
}
