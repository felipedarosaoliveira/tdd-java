package br.com.djf.ecommerce;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class EcommerceControllerMockMvcTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testExecuteController() throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.add("appVersion","122");

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/contacts").headers(headers)).andReturn();
        Assertions.assertEquals(200,result.getResponse().getStatus());
    }
}
