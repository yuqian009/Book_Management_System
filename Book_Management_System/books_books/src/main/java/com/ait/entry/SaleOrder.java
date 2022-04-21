package com.ait.entry;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity(name = "sale_order")
@Component
public class SaleOrder {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "book_id")
    private Integer booktId;

    @Column(name = "order_status")
    private Integer orderStatus;

    @Column(name = "price")
    private BigDecimal price;


    @Column(name = "bookNum")
    private Integer bookNum;

    @Column(name = "order_Amount")
    private BigDecimal orderAmount;
}
