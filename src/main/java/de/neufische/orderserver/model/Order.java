package de.neufische.orderserver.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Order {
    private int id;
    private List<Product> products = new ArrayList<>();



    public Order(int id, Product ... products) {
        this.id = id;
        this.products.addAll(Arrays.asList(products));
    }

    public Order(int id, List<Product> products) {
        this.id = id;
        this.products.addAll(products);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ");
        sb.append(id);
        sb.append("\n");
        for (Product product : products) {
            sb.append(product);
        }
    return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, products);
    }
}
