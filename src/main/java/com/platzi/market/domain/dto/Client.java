package com.platzi.market.domain.dto;

import lombok.Data;

@Data
public class Client {

    private String clientId;
    private String name;
    private String lastName;
    private Long cellphone;
    private String address;
    private String email;

}
