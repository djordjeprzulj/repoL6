package com.example.v6rest;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.v6rest.controller.TStoreController;
import com.example.v6rest.model.TStore;
import com.example.v6rest.service.TStoreService;

@RunWith(SpringRunner.class)
@WebMvcTest(TStoreController.class)
public class TStoreControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TStoreService mockStoreService;
	
	@Test
	public void findAllStores() throws Exception {
		TStore s1 = new TStore();
		s1.setId(1);
		s1.setName("Prva prodavnica");
		TStore s2 = new TStore();
		s2.setId(2);
		s2.setName("Druga prodavnica");
		List<TStore> mockList = Arrays.asList(s1, s2);
		when(mockStoreService.findAll()).thenReturn(mockList);
		
		ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/stores").accept(MediaType.APPLICATION_JSON));
		resultActions = resultActions.andExpect(status().isOk());
		MvcResult result = resultActions.andReturn();
		MockHttpServletResponse response = result.getResponse();
		/*
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/stores")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
		*/
		String expected = "[{\"id\":1,\"name\":\"Prva prodavnica\"},{\"id\":2,\"name\":\"Druga prodavnica\"}]";
		JSONAssert.assertEquals(expected, response.getContentAsString(), false);
	}
}
