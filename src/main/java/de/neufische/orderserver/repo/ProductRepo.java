package de.neufische.orderserver.repo;

import de.neufische.orderserver.model.Beer;
import de.neufische.orderserver.model.Liquor;
import de.neufische.orderserver.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepo {
    private List<Product> availableProducts = new ArrayList<>();

    public ProductRepo() {
        generateAvailableProducts();
    }

    private void generateAvailableProducts() {
        Beer pils = new Beer("Edelpils", 1, 0.49);
        Beer alt = new Beer("Düsseldorfer", 2,0.59);
        Liquor whiskey = new Liquor("Whiskey", 3,  19.99);
        Liquor gin = new Liquor("Gin", 4, 29.99);

        availableProducts.add(pils);
        availableProducts.add(alt);
        availableProducts.add(whiskey);
        availableProducts.add(gin);
    }

    public List<Product> list() {
        return this.availableProducts;
    }

    public Optional<Product> get(int id) {
        for (Product product : availableProducts) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Product availableProduct : availableProducts) {
            sb.append(availableProduct.toString());
        }
        return sb.toString();
    }

    public List<Product> searchByName(String search) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product availableProduct : availableProducts) {
            if (availableProduct.getName().toLowerCase().contains(search.toLowerCase())){
                foundProducts.add(availableProduct);
            }
        }
        return foundProducts;
    }
}
