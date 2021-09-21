package de.neufische.orderserver.controller;

import de.neufische.orderserver.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import de.neufische.orderserver.service.ShopService;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    private final ShopService shopService;

    @Autowired
    public OrderController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public String listProducts() {
        return shopService.listProducts();
    }

    @PostMapping
    public void newOrder(@RequestBody List<Product> products) {
        shopService.addOrder(products);
    }

    @GetMapping(path = "{id}")
    public String getOrder(@PathVariable int id) {
        if (shopService.getOrder(id).isPresent()) {
            return shopService.getOrder(id).get().toString();
        } else {
            throw new IllegalArgumentException("Order mit id " + id + " existiert nicht");
        }
    }
}
