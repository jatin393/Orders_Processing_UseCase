package com.kafka.shipping.constants;

public class AppConstants {
    // consume topic
    public static final String ORDER_TOPIC = "order_topic";

    // produce topic
    public static final String SHIPPED_ORDER_TOPIC = "shipped_order_topic";

    // order shipped
    public static final String ORDER_SHIPPED = "Order is shipped (deleted) from shippings database and Produced to kafka shipped_order_topic";
}
