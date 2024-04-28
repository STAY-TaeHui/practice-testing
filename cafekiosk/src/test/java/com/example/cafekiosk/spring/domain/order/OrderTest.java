package com.example.cafekiosk.spring.domain.order;

import com.example.cafekiosk.spring.domain.product.Product;
import com.example.cafekiosk.spring.domain.product.ProductSellingStatus;
import com.example.cafekiosk.spring.domain.product.ProductType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderTest {
    @DisplayName("주문 생성 시 상품 리스트에서 주문의 총 금액을 계산한다.")
    @Test
    void caculateTotalPrice() {
        //given
        //상품 리스트
        List<Product> products = List.of(createProduct("001", 1000),
                createProduct("002", 2000));

        //when
        Order order = Order.create(products);

        //then
        Assertions.assertThat(order.getTotalPrice()).isEqualTo(3000);
    }
    Product createProduct(String productNumber, int price)
    {
        return Product.builder()
                .type(ProductType.HANDMADE)
                .productNumber(productNumber)
                .sellingStatus(ProductSellingStatus.SELLING)
                .name("메뉴이름")
                .price(price)
                .build();
    }

}