package io.hoanghai.pharmacy.controller.rest;

import io.hoanghai.pharmacy.model.Order;
import io.hoanghai.pharmacy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderRestController {

    private OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public List<Order> get(){
        return orderService.findAll();
    }

    @GetMapping("/order/{id}")
    public Order get(@PathVariable(value = "id") Integer id){
        return orderService.findById(id);
    }



}
