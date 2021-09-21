package de.neufische.orderserver.model;

import java.util.Objects;

public class Beer extends Product {

    String name;
    int id;
    double price;

    public Beer(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product ID: " + id + " Beer: " + name + ", " + price + " Euro\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return id == beer.id && Double.compare(beer.price, price) == 0 && Objects.equals(name, beer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, price);
    }
}
