package com.cyp.pojo;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class User {
    private int id;
    private String name;
    private String password;

}
