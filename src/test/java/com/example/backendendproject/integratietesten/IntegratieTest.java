package com.example.backendendproject.integratietesten;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class IntegratieTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testDeleteProduct() throws Exception {
        final MockHttpServletResponse response = mockMvc.perform(delete("/products/{id}", 1001)
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();
        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo("Product has been Deleted");
    }

    @Test
    void testGetAllProduct() throws Exception{
        final MockHttpServletResponse response = mockMvc.perform(get("/products/{id}", 1001))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1001))
                .andExpect(jsonPath("name").value("Product 1"))
                .andReturn().getResponse();
        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }


}