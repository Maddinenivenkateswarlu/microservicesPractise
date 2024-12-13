package com.edureka.sagaorchestrator.service;

import com.edureka.sagaorchestrator.domain.Order;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SagaJmsListener {
    private final JmsTemplate jmsTemplate;
    private final OrderService orderService;
    
    

    public SagaJmsListener(JmsTemplate jmsTemplate, OrderService orderService) {
		super();
		this.jmsTemplate = jmsTemplate;
		this.orderService = orderService;
	}


    /**
     * airlinems and hotelms responses are handled here
     * @param order
     */
	@JmsListener(destination = "saga-queue")
    public void listen(Order order) {
        System.out.println("Message Consumed: " + order);
        orderService.processSagaResponse(order);
    }


}
