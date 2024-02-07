package com.kafka.shipping.services;


import com.kafka.shipping.models.Shipping;
import com.kafka.shipping.repositories.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    @Autowired
    private ShippingRepository shippingRepository;

    public void deleteShipper(Long orderId) {
        this.shippingRepository.deleteById(orderId);
    }

    public void saveShipper(Shipping shippingOrder) {
        this.shippingRepository.save(shippingOrder);
    }
}
