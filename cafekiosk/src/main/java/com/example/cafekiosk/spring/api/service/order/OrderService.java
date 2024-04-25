package com.example.cafekiosk.spring.api.service.order;

import java.time.LocalDateTime;
import java.util.List;

import com.example.cafekiosk.spring.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService
{

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public OrderResponse createOrder(OrderCreateRequest request, LocalDateTime registeredDateTime) {
        List<String> productNumbers = request.getProductNumbers();

        productRepository.findAllByProductNumberIn(productNumbers);
        return null;
    }

}
