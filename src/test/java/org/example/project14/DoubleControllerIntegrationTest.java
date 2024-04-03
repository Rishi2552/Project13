package org.example.project14;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DoubleControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDoubleNumberEndpoint() throws Exception {
        int inputNumber = 5;
        int expectedDouble = inputNumber * 2;

        mockMvc.perform(MockMvcRequestBuilders.get("/double")
                        .param("number", String.valueOf(inputNumber))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(expectedDouble));
    }
}


