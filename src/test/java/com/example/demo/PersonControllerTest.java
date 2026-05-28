//package com.example.demo;
//
//import com.example.demo.models.Person;
//import com.example.demo.service.PersonService;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
////import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc; // Verify this import
//import org.springframework.http.MediaType;
//import org.springframework.test.context.bean.override.mockito.MockitoBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class PersonControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockitoBean
//    private PersonService personService;
//
//    @Test
//    public void returnsJsonPerson() throws Exception {
//        Person mockPerson = new Person(1234567890L, "Annette", "Appel", 43);
//        Mockito.when(personService.jsonPerson()).thenReturn(mockPerson);
//
//        mockMvc.perform(get("/jsonPerson"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("$.id").value(1234567890L))
//                .andExpect(jsonPath("$.name").value("Annette"))
//                .andExpect(jsonPath("$.lastName").value("Appel"));
//    }
//}
package com.example.demo;

import com.example.demo.models.Person;
import com.example.demo.service.PersonService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc; // Standard
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

// Spring Boot 4.x / Spring 7 specific override annotation
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean // This is the modern replacement for @MockBean
    private PersonService personService;

    @Test
    public void returnsJsonPerson() throws Exception {
        Person mockPerson = new Person(1234567890L, "Annette", "Appel", 43);
        Mockito.when(personService.jsonPerson()).thenReturn(mockPerson);

        mockMvc.perform(get("/jsonperson"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1234567890L))
                .andExpect(jsonPath("$.name").value("Annette"));
    }
}