package com.book.mapper;

import com.book.entry.SaleOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<SaleOrder,Integer> {

}

