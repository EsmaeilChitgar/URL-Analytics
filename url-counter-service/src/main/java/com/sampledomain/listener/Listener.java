package com.sampledomain.listener;

import com.sampledomain.messages.Message;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(id = "listenerURLCounter", topics = "${message.topic1}")
public class Listener {
    @KafkaHandler
    public void handleSenderMessage(Message message) {
        System.out.println("URLCounter listener: Message received: " + message.message());
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("URLCounter listener: Unknown type received: " + object);
    }
}