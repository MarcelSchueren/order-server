package de.neufische.orderserver.controller;

import de.neufische.orderserver.model.Product;
import de.neufische.orderserver.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class AllOrderController {
    private final ShopService shopService;

    @Autowired
    public AllOrderController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public String listOrders() {
        return shopService.listOrder();
    }

    @PostMapping
    public String search(@RequestParam String search) {
       return shopService.searchByName(search).toString();
    }
}
