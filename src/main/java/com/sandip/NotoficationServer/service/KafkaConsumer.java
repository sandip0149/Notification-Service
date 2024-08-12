package com.sandip.NotoficationServer.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandip.NotoficationServer.entity.Notification;
import com.sandip.NotoficationServer.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @Autowired
    private KafkaService kafkaService;

    @Autowired
    private final ObjectMapper objectMapper;

    public KafkaConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @KafkaListener(topics = "incoming-noti" , groupId = "user-notifications")
    public void consume(String notificattion){
        Notification notification = null;
        try{
            notification = objectMapper.readValue(notificattion,Notification.class);
        } catch (JsonProcessingException e){
            e.printStackTrace();
            System.out.println("Error in parse from string to json");
        }

        if(notification.getType() == Type.Transactional ) {
            kafkaService.transMessage(notificattion);
        }
        else {
            kafkaService.promoMessage(notificattion);
        }
    }


}
