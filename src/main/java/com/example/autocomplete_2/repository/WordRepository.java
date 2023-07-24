package com.example.autocomplete_2.repository;

import com.example.autocomplete_2.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word,Long> {

}
