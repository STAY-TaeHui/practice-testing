package com.example.cafekiosk.spring.api.service.order;

import java.time.LocalDateTime;
import java.util.List;

import com.example.cafekiosk.spring.api.service.product.response.ProductResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class OrderResponse
{
    private Long id;
    private int totalPrice;

    private LocalDateTime registeredDateTime;

    private List<ProductResponse> productResponses;

}
