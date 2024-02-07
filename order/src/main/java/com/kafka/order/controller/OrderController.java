package com.kafka.order.controller;

import com.kafka.order.model.Order;
import com.kafka.order.repositories.OrderRepository;
import com.kafka.order.service.OrderProducer;
import com.kafka.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.kafka.order.constants.AppConstants.*;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {

    private final OrderProducer orderProducer;

    @Autowired
    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping(path = "/produce")
    public String saveAndProduceOrder(@RequestBody Order order){
        Order ordersWithId = this.orderService.getOrders(order);
        System.out.println(ordersWithId);
        orderProducer.produceOrder(ordersWithId);
        return MESSAGE_SUCCESS;
    }

    @PutMapping("/update/{orderId}")
    public String updateOrder(@RequestBody Order order, @PathVariable("orderId") Long orderId){
        Order updateOrder = this.orderService.updateOrder(order,orderId);
        System.out.println(updateOrder);
        orderProducer.produceOrder(updateOrder);
        return ORDER_UPDATED;
    }
    
    public void updateOrder(Long orderId) {
        Order orders = this.orderService.getOrderUpdate(orderId);
        System.out.println(orders);
        System.out.println(ORDER_SHIPPED);
    }
}
