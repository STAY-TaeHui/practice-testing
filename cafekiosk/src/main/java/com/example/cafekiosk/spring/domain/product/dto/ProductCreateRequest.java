package com.example.cafekiosk.spring.domain.product.dto;

import com.example.cafekiosk.spring.domain.product.ProductSellingStatus;
import com.example.cafekiosk.spring.domain.product.ProductType;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;


public class ProductCreateRequest
{
    @NotNull(message = "상품 타입은 필수입니다.")
    private ProductType type;

    @NotNull(message = "상품 판매상태는 필수입니다.")
    private ProductSellingStatus sellingStatus;

    @NotNull(message = "상품 이름은 필수입니다.")
    private String name;

    @NotNull(message = "상품 가격은 양수이어야 합니다.")
    private int price;

    @Builder
    public ProductCreateRequest(ProductType type, ProductSellingStatus sellingStatus, String name, int price)
    {
        this.type = type;
        this.sellingStatus = sellingStatus;
        this.name = name;
        this.price = price;
    }

    public ProductCreateRequest toServiceRequest()
    {
        return ProductCreateRequest.builder()
            .type(type)
            .sellingStatus(sellingStatus)
            .name(name)
            .price(price)
            .build();
    }
}
