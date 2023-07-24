package com.example.autocomplete_2.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.getChildren().putIfAbsent(ch, new TrieNode());
            node = node.getChildren().get(ch);
        }
        node.setEndOfWord(true);
    }

    public List<String> search(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.getChildren().containsKey(ch)) {
                return Collections.emptyList();
            }
            node = node.getChildren().get(ch);
        }
        return findAllWordsFromNode(node, prefix);
    }

    private List<String> findAllWordsFromNode(TrieNode node, String prefix) {
        List<String> words = new ArrayList<>();
        if (node.isEndOfWord()) {
            words.add(prefix);
        }

        for (char ch : node.getChildren().keySet()) {
            words.addAll(findAllWordsFromNode(node.getChildren().get(ch), prefix + ch));
        }
        return words;
    }
}
