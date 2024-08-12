package com.sandip.NotoficationServer.service;

import com.sandip.NotoficationServer.entity.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String , String> kafkaTemplate;


    public String producemessage(String message){
        kafkaTemplate.send("incoming-noti" ,message);
        return "Publish sucessfully";
    }

    public void transMessage(String message){
        kafkaTemplate.send("transactional" , message);
        System.out.println("Transactional Message Published Successfully");
    }
    public void promoMessage(String message){
        kafkaTemplate.send("promotional" , message);
        System.out.println("Promotional Message Published Successfully");
    }
}
