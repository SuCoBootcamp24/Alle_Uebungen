package org.example;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap;
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
        return orderList
                .stream()
                .map(order ->
                        new AbstractMap.SimpleEntry<Customer, Integer>(
                                order.getCustomer(), // key von entry
                                order.getProducts().containsKey(product) ? order.getProducts().get(product) : 0 // value von entry
                        )
                )
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Customer, Integer>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

    }

    //Welche Produktkategorie bringt den meisten Umsatz ?
    public Category mostProfitableCategory() {
        return orderList.stream()
                .flatMap(order -> order.getProducts().entrySet().stream()) // Produkte jeder Bestellung in einen Stream umwandeln
                .map(orderProductEntry -> new AbstractMap.SimpleEntry<Category, Double>(
                        orderProductEntry.getKey().getProductCategory(), // Key von entry
                        orderProductEntry.getKey().getPrice() * orderProductEntry.getValue().doubleValue() // Value von entry
                ))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingDouble(Map.Entry::getValue)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Was ist der durschnittliche Wert einer Bestellung in einem gegebnen Zeitraum ?
    public double averageOrderValueInTimeRange(Instant startDate, Instant endDate) {
        return Math.round(orderList.stream()
                .filter(o -> !o.getOrderDate().isBefore(startDate) && !o.getOrderDate().isAfter(endDate))
                .mapToDouble(Order::totalOrderValue)
                .average()
                .orElse(0.0) * 100.0) / 100.0;
    }

    // Was ist der gesamte Shopumsatz in einem gegebene Zeitraum ?
    public double totalShopValueInTimeRange(Instant startDate, Instant endDate) {
        return Math.round(orderList.stream()
                .filter(o -> !o.getOrderDate().isBefore(startDate) && !o.getOrderDate().isAfter(endDate))
                .mapToDouble(Order::totalOrderValue)
                .sum() * 100.0) / 100.0;
    }

    // Wieviel % der Kunden haben mehrmals gekauf "returning customer rate"
    public double returningCustomerRate() {
        long numberOfCustomersWhoBoughtAtLeastTwice = orderList
                .stream()
                .map(Order::getCustomer)
                .collect(Collectors.groupingBy(
                        (customer) -> customer,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter((entry) -> entry.getValue() >= 2)
                .count();
        int numberOfCustomers = orderList
                .stream()
                .map(Order::getCustomer)
                .collect(Collectors.toSet())
                .size();
        if (numberOfCustomers == 0) throw new IllegalStateException("No customers at all (can not divide by zero)");
        return numberOfCustomersWhoBoughtAtLeastTwice / (double) numberOfCustomers;
    }

    // Durschnittliche Anzahl von Produkten pro Bestellung
    public double averageProductsPerOrder() {
        return 0.0; // keine Lösung .... ich gebe auf
    }

    // Produkt dass am Meisten von unterschiedlichen Kunden bestellt wurde...
    public Product mostPopularProduct() {
        return orderList.stream()
                .flatMap(order -> order.getProducts().entrySet().stream())
                .map(orderProductEntry -> new AbstractMap.SimpleEntry<>(
                         orderProductEntry.getKey(),
                         orderProductEntry.getValue()
                 ))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingInt(Map.Entry::getValue)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    // Umsatzstärkster Tag...
    public LocalDate mostProfitableDay() {
        //....
        return null; // keine Lösung .... ich gebe auf
    }
}