package de.supercode.eshop.entitys.orders;

import de.supercode.eshop.entitys.persons.Customer;
import de.supercode.eshop.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

import lombok.Data;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "customer_order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Customer customer;

    private Status status;

    private BigDecimal totalPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();


    @Override
    public int hashCode() {
        return Objects.hash(id);  // Nutze nur die ID
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);  // Vergleiche nur die ID
    }

}
