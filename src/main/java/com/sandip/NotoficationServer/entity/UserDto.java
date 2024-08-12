package com.sandip.NotoficationServer.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Integer id;

    private String name;

    private String email;

    private String preference;

    private String phoneNo;

}
