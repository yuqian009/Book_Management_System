package com.ait.entry;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "sc_user")
@Component
@Data

public class BookUser {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Integer id ;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;


    @Column(name = "country")
    private String country;






}