package com.example.cafekiosk.spring.domain.order;

import com.example.cafekiosk.spring.domain.product.Product;
import com.example.cafekiosk.spring.domain.product.ProductSellingStatus;
import com.example.cafekiosk.spring.domain.product.ProductType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        Order order = Order.create(products, LocalDateTime.now());

        //then
        assertThat(order.getTotalPrice()).isEqualTo(3000);
    }

    @DisplayName("주문 생성 시 주문 등록 시간을 기록한다.")
    @Test
    void registeredDateTime()
    {
        // given
        LocalDateTime now = LocalDateTime.now();//현재 시간을 넣기보단, 특정 시간을 만들어서 넣자.
        List<Product> product = List.of(
            createProduct("001", 1000),
            createProduct("002", 2000)
        );
        // when
        Order order = Order.create(product, now);

        // then
        assertThat(order.getRegisteredDateTime()).isEqualTo(now);
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