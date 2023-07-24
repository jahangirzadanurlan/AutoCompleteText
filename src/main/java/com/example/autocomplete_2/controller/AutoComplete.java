package com.example.autocomplete_2.controller;

import com.example.autocomplete_2.model.Trie;
import com.example.autocomplete_2.service.AutoCompleteServiceI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class AutoComplete {
    private final AutoCompleteServiceI autoCompleteService;
    private Trie trie;

    @PostConstruct
    public void initializeTrie() {
        trie = new Trie();
        autoCompleteService.getAllWords().forEach(word -> trie.insert(word));
    }

    @GetMapping("/")
    public String autoCompletePage() {
        return "auto_complete";
    }

    @GetMapping("/autocomplete")
    @ResponseBody
    public List<String> autoComplete(@RequestParam("term") String term) {
        // Kullanıcıdan gelen terime göre Trie yapısını kullanarak önerileri alın
        return trie.search(term.toLowerCase());
    }
}

