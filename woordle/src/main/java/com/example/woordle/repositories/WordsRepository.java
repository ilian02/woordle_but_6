package com.example.woordle.repositories;

import com.example.woordle.domain.Word;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepository extends CrudRepository<Word, Long> {
}
