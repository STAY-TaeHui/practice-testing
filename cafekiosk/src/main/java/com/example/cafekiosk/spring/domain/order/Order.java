package com.example.cafekiosk.spring.domain.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.cafekiosk.spring.domain.BaseEntity;
import com.example.cafekiosk.spring.domain.product.Product;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private int totalPrice;

    private LocalDateTime registeredDateTime;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderProduct> orderProduct = new ArrayList<>();

    public Order(List<Product> products, LocalDateTime registeredDateTime)
    {
        this.orderStatus = OrderStatus.INIT;
        this.totalPrice = calculateTotalPrice(products);
        this.registeredDateTime = registeredDateTime;
        this.orderProduct = products.stream()
            .map(product -> new OrderProduct(this, product))
            .toList();
    }

    public static Order create(List<Product> products, LocalDateTime registeredDateTime)
    {
        return new Order(products, registeredDateTime);
    }

    private int calculateTotalPrice(List<Product> products)
    {
        return products.stream()
                .mapToInt(Product::getPrice)
                .sum();
    }
}
