package com.example.demo.cucumber.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class PersonSteps {
    @Autowired
    private MockMvc mockMvc;

    private ResultActions response;

    @When("I request the json person endpoint")
    public void requestJsonPerson() throws Exception {
        response = mockMvc.perform(get("/jsonperson"));
    }

    @Then("the response should contain the name {string}")
    public void verifyName(String name) throws Exception {
        response.andExpect(jsonPath("$.name").value(name));
    }
}
