package com.spring.apachecamel.consumer;


import javax.jms.Queue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.apachecamel.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consume")
public class Consumer {
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @GetMapping("/message")
    public Product consumeMessage() {

        Product product = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            String jsonMessage = (String) jmsTemplate.receiveAndConvert(queue);
            product = mapper.readValue(jsonMessage, Product.class);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
}