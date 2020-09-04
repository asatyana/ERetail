package com.ananth.retail.repositories;

import com.ananth.retail.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
