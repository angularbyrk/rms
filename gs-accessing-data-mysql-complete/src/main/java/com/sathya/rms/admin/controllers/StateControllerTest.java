/*

package com.sathya.rms.admin.controllers;


import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.sathya.rms.admin.services.StateService;

@RunWith(SpringRunner.class)
@WebMvcTest(StateControllerTest.class)
public class StateControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private StateService service;

  @Test
  public void greetingShouldReturnMessageFromService() throws Exception {
    when(service.greet()).thenReturn("Hello Mock");
    this.mockMvc.perform(get("/greeting")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello Mock")));
  }
}

*/