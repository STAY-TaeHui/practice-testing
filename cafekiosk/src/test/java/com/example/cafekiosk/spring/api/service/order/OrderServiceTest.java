package com.example.cafekiosk.spring.api.service.order;

import static com.example.cafekiosk.spring.domain.product.ProductSellingStatus.*;
import static com.example.cafekiosk.spring.domain.product.ProductType.HANDMADE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import com.example.cafekiosk.spring.domain.product.Product;
import com.example.cafekiosk.spring.domain.product.ProductRepository;
import com.example.cafekiosk.spring.domain.product.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@DataJpaTest
class OrderServiceTest
{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;

    @DisplayName("주분번호 리스트를 받아 주문을 생성한다.")
    @Test
    void createOrder()
    {
        // given
        Product product1 = createProduct(HANDMADE, "001", 1000);
        Product product2 = createProduct(HANDMADE,"002", 3000);
        Product product3= createProduct(HANDMADE,"003", 5000);

        productRepository.saveAll(List.of(product1, product2, product3));

        OrderCreateRequest createRequest =
            OrderCreateRequest.builder().productNumbers(List.of("001", "002", "003")).build();

        // when

        OrderResponse orderResponse = orderService.createOrder(createRequest, LocalDateTime.now());
        // then
        assertThat(orderResponse.getId()).isNotNull();
        assertThat(orderResponse)
            .extracting("registeredDateTime", "totalPrice")
            .contains("???", 9000);

        assertThat(orderResponse.getProductResponses())
            .extracting("productNumbers", "price")
            .containsExactlyInAnyOrder(
                tuple("001", 1000),
                tuple("002", 3000),
                tuple("003", 5000)
            );

    }

    Product createProduct(ProductType productType, String productNumber, int price)
    {
        return Product.builder()
            .productNumber(productNumber)
            .type(productType)
            .name("메뉴이름")
            .price(price)
            .build();
    }
}