package com.example.cafekiosk.spring.domain.product;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProductTypeTest
{
    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    @Test
    void containsStockTypeHandMade()
    {
        // given
        ProductType handmade = ProductType.HANDMADE;

        // when
        boolean result = ProductType.containsStockType(handmade);
        // then
        assertThat(result).isFalse();
    }

    @DisplayName("상품 타입이 재고 관련 타입인지를 체크한다.")
    @Test
    void containsStockTypeBakery()
    {
        // given
        ProductType bakery = ProductType.BAKERY;

        // when
        boolean result = ProductType.containsStockType(bakery);
        // then
        assertThat(result).isTrue();
    }

}