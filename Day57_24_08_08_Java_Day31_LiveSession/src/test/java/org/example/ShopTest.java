package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class ShopTest {

    private Shop shop;
    private Customer kazim;
    private Customer anna;

    private Customer viktor;

    private Product monitor;
    private Product perfume;

    @BeforeAll
    void setup() {
        shop = new Shop();

        LocalDateTime kursbeginn = LocalDateTime.of(2024, Month.MAY, 21, 8, 45);
        Instant kursbeginnInstant = kursbeginn.toInstant(ZoneOffset.UTC);

        LocalDateTime testKaufdatum = LocalDateTime.of(2024, Month.AUGUST, 21, 8, 45);
        Instant testKaufdatumInstant = kursbeginn.toInstant(ZoneOffset.UTC);

        kazim = new Customer("Kazim", "Sakip", "k.s@gmail.com", Instant.now());
        viktor = new Customer("Viktor", "Steiner", "viktors@gmail.com", kursbeginnInstant);
        anna = new Customer("Anna", "Patschen", "annapatschen@gmail.com", Instant.now());

        Product uhr = new Product("Uhr", "hilft dabei die Zeit zu lesen", 150.0f, "U139030", Category.CLOTHING);
        Product rolex = new Product("Rolex Uhr", "hilft dabei die Zeit zu lesen", 18000.0f, "U144430", Category.CLOTHING);
        Product soundMachine = new Product("Sound Machine", "Macht viele geräusche auf Tastenklick", 9.0f, "SM239", Category.ELECTRONICS);
        Product pinzette = new Product("Pinzette", "Pinzette mit integrierte LED", 2.49f, "P800", Category.BEAUTY);
        monitor = new Product("Monitor Groß", "Monitor mit vielen kleinen Pixeln", 250.0f, "LG239340e", Category.ELECTRONICS);
        Product keyboard = new Product("Keyboard", "Keyboard mit vielen Tasten", 100.0f, "K239340e", Category.ELECTRONICS);
        perfume = new Product("Perfume", "Riecht echt gut hmmmn (100ml)", 100.0f, "P239340e", Category.BEAUTY);

        Order o1 = new Order(kazim);
        Order o2 = new Order(kazim);
        Order o3 = new Order(kazim);

        Order o4 = new Order(viktor);

        Order o5 = new Order(anna);
        Order o6 = new Order(anna);

        o1.addProduct(uhr, 1);
        o1.addProduct(rolex, 1);
        o1.addProduct(pinzette, 2);
        o1.setHasPaid(true);
        o1.setOrderDate(kursbeginnInstant);
        shop.addOrder(o1);

        o2.addProduct(monitor, 1);
        o2.setHasPaid(false);
        o2.setOrderDate(testKaufdatumInstant);
        shop.addOrder(o2);

        o3.addProduct(soundMachine, 1);
        o3.setHasPaid(true);
        o3.setOrderDate(Instant.now());
        shop.addOrder(o3);

        o4.addProduct(monitor, 12);
        o4.addProduct(keyboard, 12);
        o4.setHasPaid(true);
        o4.setOrderDate(kursbeginnInstant);
        shop.addOrder(o4);

        o5.addProduct(perfume, 1);
        o5.addProduct(rolex, 2);
        o5.setHasPaid(true);
        o5.setOrderDate(Instant.now());
        shop.addOrder(o5);

        o6.addProduct(monitor, 5);
        o6.addProduct(pinzette, 1);
        o6.setHasPaid(true);
        o6.setOrderDate(Instant.now());
        shop.addOrder(o6);
    }

    @Test
    void totalOrderValue() {
        assertEquals(18154.98f, shop.getOrderList().get(0).totalOrderValue());
    }

    @Test
    void customerWithMostOrders() {
        assertEquals(kazim, shop.customerWithMostOrder());
    }


    @Test
    void customerWithHighestLifetimeValue() {
        assertEquals(anna, shop.customerWithHighestLifetimeValue());
    }

    @Test
    void longestCustomer() {
        assertEquals(kazim, shop.longestCustomer());
    }

    @Test
    void bestProduct() {
        assertEquals(this.monitor, shop.bestProduct());
    }

    @Test
    void worstProduct() {
        assertEquals(this.perfume, shop.worstProduct());
    }

    @Test
    void averageOrderValue() {
        assertEquals(9786.08, shop.averageOrderValue());
    }

    @Test
    void customerListWithOrderAboveX() {
        assertEquals(2, shop.customerListWithOrderAboveX(10000.0).size());
    }

    @Test
    void topNCustomersForProduct() {
        List<Customer> expectedCustomers = new ArrayList<Customer>(Arrays.asList (viktor, anna));

        List<Customer> receivedCustomers = shop.topNCustomersForProduct(2, this.monitor);

        assertEquals(2, receivedCustomers.size());
        assertEquals(expectedCustomers, receivedCustomers);

    }

    @Test
    void mostProfitableCategory() {
        assertEquals(Category.CLOTHING, shop.mostProfitableCategory());
    }

    @Test
    void averageOrderValueInTimeRange() {
        LocalDateTime startDate = LocalDateTime.of(2024, Month.MAY, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2024, Month.AUGUST, 30, 23, 59);
        Instant startDateInstant = startDate.toInstant(ZoneOffset.UTC);
        Instant endDateInstant = endDate.toInstant(ZoneOffset.UTC);

        assertEquals(9994.41, shop.averageOrderValueInTimeRange(startDateInstant, endDateInstant));
    }

    @Test
    void totalShopValueInTimeRange() {
        LocalDateTime startDate = LocalDateTime.of(2024, Month.MAY, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2024, Month.AUGUST, 30, 23, 59);
        Instant startDateInstant = startDate.toInstant(ZoneOffset.UTC);
        Instant endDateInstant = endDate.toInstant(ZoneOffset.UTC);

        assertEquals(59966.47, shop.totalShopValueInTimeRange(startDateInstant, endDateInstant));
    }

    @Test
    void returningCustomerRate() {
        assertEquals(2.0/3.0, shop.returningCustomerRate());
    }

    @Test
    void averageProductsPerOrder() {
        assertEquals(2.0, shop.averageProductsPerOrder());
    }


    @Test
    void mostPopularProduct() {
        assertEquals(this.monitor, shop.mostPopularProduct());
    }

    // Durschnittliche Anzahl von Produkten pro Bestellung


    // Umsatzstärkster Tag...




}