package com.edureka.sagaorchestrator.service;

import com.edureka.sagaorchestrator.domain.Order;
import com.edureka.sagaorchestrator.domain.OrderEvent;
import com.edureka.sagaorchestrator.domain.OrderState;
import com.edureka.sagaorchestrator.repository.OrderRepository;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AirlineAction implements Action<OrderState, OrderEvent> {
    private final JmsTemplate jmsTemplate; // client to JMS(Java Messaging Service) for ActiveMQ
    private final OrderRepository orderRepository;
    
    public AirlineAction(JmsTemplate jmsTemplate, OrderRepository orderRepository) {
		super();
		this.jmsTemplate = jmsTemplate;
		this.orderRepository = orderRepository;
	}

	@Override
    public void execute(StateContext<OrderState, OrderEvent> context) {
        System.out.println("Airline Action");
        String orderId = (String) context.getMessage().getHeaders().get("ORDER_ID_HEADER");
        System.out.println("$$$$ AirlineAction " + orderId + " $$$$");
        Optional<Order> orderOptional = orderRepository.findById(Long.parseLong(orderId));
        jmsTemplate.convertAndSend("airline-queue", orderOptional.get());

    }
}
