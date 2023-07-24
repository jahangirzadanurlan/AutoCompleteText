package com.example.autocomplete_2.service.impl;

import com.example.autocomplete_2.repository.WordRepository;
import com.example.autocomplete_2.service.AutoCompleteServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AutoCompleteService implements AutoCompleteServiceI {
    private final WordRepository wordRepository;

    @Override
    public List<String> getAllWords() {
        List<String> words = wordRepository.findAll().stream()
                .map(word -> word.getName())
                .collect(Collectors.toList());
        return words;
    }
}
