package com.restapi.CrudExample3.repositroy;

import com.restapi.CrudExample3.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Books,Integer> {
    Books findByName(String name);
}
