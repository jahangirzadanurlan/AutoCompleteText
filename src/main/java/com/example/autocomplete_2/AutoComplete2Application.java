package com.example.autocomplete_2;

import com.example.autocomplete_2.entity.Word;
import com.example.autocomplete_2.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@EnableCaching
public class AutoComplete2Application {
    private final WordRepository wordRepository;

    public static void main(String[] args) {
        SpringApplication.run(AutoComplete2Application.class, args);
    }
/*
    @Bean
    public CommandLineRunner initData() {
        return args -> {
            List<String> wordList = readWordListFromFile("C:\\Users\\cahan\\IdeaProjects\\AutoComplete_2\\src\\main\\resources\\static\\words.txt");
            insertWordsToDatabase(wordList);
        };
    }

    public List<String> readWordListFromFile(String fileName) {
        List<String> wordList = new ArrayList<>();
        try {
            wordList = Files.readAllLines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordList;
    }

    public void insertWordsToDatabase(List<String> wordList) {
        for (String word : wordList) {
            Word _word = Word.builder()
                    .name(word)
                    .build();
            wordRepository.save(_word);
        }
    }
 */
}
