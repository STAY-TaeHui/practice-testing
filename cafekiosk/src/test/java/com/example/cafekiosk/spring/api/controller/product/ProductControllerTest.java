package com.example.cafekiosk.spring.api.controller.product;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.cafekiosk.spring.api.service.product.ProductService;
import com.example.cafekiosk.spring.domain.product.ProductSellingStatus;
import com.example.cafekiosk.spring.domain.product.ProductType;
import com.example.cafekiosk.spring.domain.product.dto.ProductCreateRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//Controller단의 가벼운 테스트만 할 수 있는 어노테이션
@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper; //역직렬화 -> 기본 생성자 필요

    @DisplayName("신규 상품을 등록한다.")
    @Test
    void createProduct() throws Exception
    {
        // given
        //TODO
        // request를 만들고
        ProductCreateRequest request = ProductCreateRequest.builder()
            .name("아메리카노")
            .price(1000)
            .type(ProductType.HANDMADE)
            .sellingStatus(ProductSellingStatus.SELLING)
            .build();

        // when then
        //API 호출
        mockMvc.perform(post("/api/v1/products/new")
            .content(objectMapper.writeValueAsString(request))
            .contentType(MediaType.APPLICATION_JSON)
        )
            .andDo(print()) //자세한 로그
            .andExpect(status().isOk());

    }
}