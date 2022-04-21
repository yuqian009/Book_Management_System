package com.ait.mapper;

import com.ait.entry.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<BookUser,Integer> {
}

