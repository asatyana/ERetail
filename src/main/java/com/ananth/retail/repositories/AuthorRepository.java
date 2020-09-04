package com.ananth.retail.repositories;

import com.ananth.retail.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
