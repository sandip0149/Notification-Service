package com.sandip.NotoficationServer.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    private String sendTo;

    private String from;

    private String message;


    private Type type;

    @Override
    public String toString() {
        return "Notification{" +
                "sendTo='" + sendTo + '\'' +
                ", from='" + from + '\'' +
                ", message='" + message + '\'' +
                ", type=" + type +
                '}';
    }
}
