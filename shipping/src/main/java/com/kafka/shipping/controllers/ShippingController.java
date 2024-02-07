package com.kafka.shipping.controllers;

import com.kafka.shipping.services.ShippedOrderIdProducer;
import com.kafka.shipping.models.Shipping;
import com.kafka.shipping.repositories.ShippingRepository;
import com.kafka.shipping.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.kafka.shipping.constants.AppConstants.ORDER_SHIPPED;

@RestController
@RequestMapping(path = "/shipping")
public class ShippingController {

    private final ShippedOrderIdProducer shippedOrderIdProducer;

    public ShippingController(ShippedOrderIdProducer shippedOrderIdProducer) {
        this.shippedOrderIdProducer = shippedOrderIdProducer;
    }

    @Autowired
    private ShippingRepository shippingRepository;

    @Autowired
    private ShippingService shippingService;

    @DeleteMapping(path = "/shipped/{orderId}")
    public String produceAndDeleteOrderId(@PathVariable Long orderId){
        shippedOrderIdProducer.produceOrderId(orderId);
        this.shippingService.deleteShipper(orderId);
        return ORDER_SHIPPED;
    }

    @GetMapping
    public List<Shipping> getOrdersToShipping(){
        return shippingRepository.findAll();
    }

    public void saveShipping(Shipping shippingOrder) {
        this.shippingService.saveShipper(shippingOrder);
        System.out.println("saved in Shipping DB");
    }
}
