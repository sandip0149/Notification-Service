package com.sandip.NotoficationServer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandip.NotoficationServer.entity.Notification;
import com.sandip.NotoficationServer.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
public class rest {

    @Autowired
    private KafkaService kafkaService;

    @Autowired
    private final ObjectMapper objectMapper;

    public rest(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    @PostMapping
    public String publish(@RequestBody Notification notifica){
        String notification;
        try{
              notification = objectMapper.writeValueAsString(notifica);
        } catch (JsonProcessingException e){
            e.printStackTrace();
            return "Failed to publish by json";
        }


        return kafkaService.producemessage(notification);
    }
}
