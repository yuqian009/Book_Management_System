package com.ait.entry;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "sc_book")
@Component


public class BookBooks {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Integer id ;



    @Column(name = "name")
    private String name;


    @Column(name = "author")
    private String author;


    @Column(name = "price")
    private BigDecimal price;


    @Column(name = "cover")
    private String cover;


}
