package com.example.postapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;
}
