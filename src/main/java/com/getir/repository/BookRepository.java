package com.getir.repository;

import com.getir.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository < Book , Integer> {

}
