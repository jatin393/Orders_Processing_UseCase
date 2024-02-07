package com.kafka.order.constants;

public class AppConstants {

    // produce topic
    public static final String ORDER_TOPIC = "order_topic";

    // consume topic
    public static final String SHIPPED_ORDER_TOPIC = "shipped_order_topic";

    // message sent to the user

    public static final String MESSAGE_SUCCESS = "saved in orders DB and produced to kafka order_topic";
    public static final String ORDER_SHIPPED = "order is shipped";
    public static final String ORDER_UPDATED = "Order has been updated";

}
