package com.tek.genshinbuildapp.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class User {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @Column(unique = true, length = 20)
    String username;
    @Column(length = 32)
    String password;
}
