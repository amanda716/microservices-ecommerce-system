package com.example.product;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;
@WebMvcTest(ProductController.class)
public class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ProductService productService;

    @Test
    void testCreateProduct() throws JsonProcessingException {
        ProductRequest request = new ProductRequest(1, "Test Product", "Test Description", 10, BigDecimal.valueOf(100.00), 1);
       
        System.out.println(objectMapper.writeValueAsString(request) );
        try {
            MvcResult result = mockMvc.perform(post("/api/v1/products")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$").value(0))
                    .andReturn();
            System.out.println("===" + result.getResponse().getContentAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void testPurchaseProducts() {
        ProductPurchaseResponse response = new ProductPurchaseResponse(1, "Test Product", "Test Description", BigDecimal.valueOf(100.00), 2);
        given(productService.purchaseProducts(anyList())).willReturn(List.of(response));
        try {
            mockMvc.perform(post("/api/v1/products/purchase")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("[{\"productId\":1,\"quantity\":2}]"))
                    // .content(objectMapper.writeValueAsString(new ProductPurchaseRequest(1, 2))))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].productId").value(1))
                    .andExpect(jsonPath("$[0].name").value("Test Product"))
                    .andExpect(jsonPath("$[0].description").value("Test Description"))
                    .andExpect(jsonPath("$[0].price").value(100.00))
                    .andExpect(jsonPath("$[0].quantity").value(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
