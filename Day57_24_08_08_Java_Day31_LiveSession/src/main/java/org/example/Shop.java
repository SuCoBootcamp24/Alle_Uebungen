package org.example;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Shop {
    private List<Order> orderList;

    public Shop() {
        this.orderList = new ArrayList<>();
    }

    public Order addOrder(Order order) {
        this.orderList.add(order);
        return order;
    }

    public Order removeOrder(Order order) {
        this.orderList.remove(order);
        return order;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    // o1, o2, o3,     o4, ...
    // <c1> <c1> <c1>  <c2>
    public Customer customerWithMostOrder() {
        return orderList
                .stream()
                .collect(Collectors.groupingBy(Order::getCustomer))
                .entrySet().stream()
                .max(Comparator.comparing(entry -> entry.getValue().size()))
                .map(entry -> entry.getKey())
                .orElse(null);
    }



    // Welcher Kunde hat den größten Umsatz gebracht ? AUFGABE
    public Customer customerWithHighestLifetimeValue() {
        return orderList
                .stream()
                .collect(Collectors.toMap(Order::getCustomer, Order::totalOrderValue ,Float::sum))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Welcher Kunde ist am längsten Dabei ?
    public Customer longestCustomer() {
        return orderList.stream()
                .map(Order::getCustomer)
                .distinct()
                .max(Comparator.comparingInt(customer -> Math.toIntExact(orderList.stream()
                        .filter(order -> order.getCustomer().equals(customer))
                        .count())))
                .orElse(null);
    }

    // Was ist das beliebteste Produkt ? (am meisten gekauft)
    public Product bestProduct() {
        return orderList.stream()
                .flatMap(order -> order.getProducts().entrySet().stream())
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Was ist das unbeliebteste Produkt ?
    public Product worstProduct() { // Klappt nicht richtig glaub ich :D
        return orderList.stream()
                .flatMap(order -> order.getProducts().entrySet().stream())
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Was ist der durschnittliche Wert einer Bestellung ?
    public double averageOrderValue() {
        return Math.round(orderList.stream()
                .mapToDouble(Order::totalOrderValue)
                .average()
                .orElse(0.0) * 100.0) / 100.0;
    }

    // Liste an Kunden ab einem Bestellungsvert über X
    public List<Customer> customerListWithOrderAboveX(double x) {
        return orderList.stream()
               .filter(order -> order.totalOrderValue() > x)
               .map(Order::getCustomer)
               .distinct()
               .collect(Collectors.toList());
    }

    //die Top-N Kunden für ein bestimmtes Produkt basierend auf der Anzahl der Bestellungen dieses Produkts
    public List<Customer> topNCustomersForProduct(int n, Product product) {
        return orderList.stream()
               .filter(order -> order.getProducts().containsKey(product))
               .sorted(Comparator.comparing(Order::totalOrderValue).reversed())
               .limit(n)
               .map(Order::getCustomer)
               .distinct()
               .collect(Collectors.toList());

    }

    //Welche Produktkategorie bringt den meisten Umsatz ?
    public Category mostProfitableCategory() {  // keine ahnung ....
        return  orderList.stream()
                .collect(Collectors.groupingBy(Product::getProductCategory))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);


    }

}