package de.neufische.orderserver.service;

import de.neufische.orderserver.model.Order;
import de.neufische.orderserver.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.neufische.orderserver.repo.OrderRepo;
import de.neufische.orderserver.repo.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;
    int idForOrders = 1;

    @Autowired
    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Optional<Product> getProduct(int id) {
        return productRepo.get(id);
    }

    public String listProducts() {
        return productRepo.toString();
    }

    public Optional<Order> getOrder(int id) {
        return orderRepo.get(id);
    }

    public String listOrder() {
        return orderRepo.toString();
    }

    public void addOrder(Product... products) {
        Order order = new Order(idForOrders, products);
        orderRepo.add(order);
        idForOrders++;
    }

//    public void addOrder(List<Product> products) {
//        Order order = new Order(idForOrders, products);
//        orderRepo.add(order);
//        idForOrders++;
//    }

    public void addOrder(List<Product> products) {
        Order order = new Order(idForOrders, products);
        orderRepo.add(order);
        idForOrders++;
    }

    public List<Product> searchByName(String search) {
        return productRepo.searchByName(search);
    }
}
