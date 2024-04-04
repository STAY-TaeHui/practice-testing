package com.example.cafekiosk.unit;

import static org.junit.jupiter.api.Assertions.*;

import com.example.cafekiosk.unit.beverage.Americano;
import org.junit.jupiter.api.Test;

class CafeKioskTest
{

    @Test
    void add()
    {
        CafeKiosk cafeKiosk = new CafeKiosk();
        cafeKiosk.add(new Americano());

        System.out.println(">>>> 담긴 음료 수 : "+ cafeKiosk.getBeverages().size());
        System.out.println(">>>> 담긴 음료 : " + cafeKiosk.getBeverages().get(0).getName());
    }

    @Test
    void remove()
    {
    }

    @Test
    void clear()
    {
    }

    @Test
    void calculateTotalPrice()
    {
    }

    @Test
    void createOrder()
    {
    }
}