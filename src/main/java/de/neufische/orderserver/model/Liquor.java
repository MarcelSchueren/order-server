package de.neufische.orderserver.model;

import java.util.Objects;

public class Liquor extends Product{

    String name;
    int id;
    int alcoholContent;
    double price;

    public Liquor(String name, int id, double price) {
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
        return "Product ID: "+  id + " Liquor: " + name + ", " + price + " Euro\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Liquor liquor = (Liquor) o;
        return id == liquor.id && alcoholContent == liquor.alcoholContent && Double.compare(liquor.price, price) == 0 && Objects.equals(name, liquor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, alcoholContent, price);
    }
}
