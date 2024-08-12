package com.example.cafekiosk.spring.api.controller.product;

import static org.junit.jupiter.api.Assertions.*;

import com.example.cafekiosk.spring.api.service.product.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//Controller단의 가벼운 테스트만 할 수 있는 어노테이션
@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @DisplayName("신규 상품을 등록한다.")
    @Test
    void testMethodNameHere()
    {
        // given
        //API 호출
        mockMvc.perform(MockMvcRequestBuilders.post())
        // when

        // then
        assertThat(actual).isEqualTo(expected);
    }
}