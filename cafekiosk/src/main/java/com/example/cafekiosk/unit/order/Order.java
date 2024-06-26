package com.example.cafekiosk.unit.order;

import java.time.LocalDateTime;
import java.util.List;

import com.example.cafekiosk.unit.beverage.Beverage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Order
{
    private final LocalDateTime orderDateTime;
    private final List<Beverage> beverages;

}
