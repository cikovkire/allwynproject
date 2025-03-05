package com.bookstore.payloads;

import com.bookstore.model.Author;

import java.util.HashMap;
import java.util.Map;

public class UpdateAuthorPayload {
    public Author updateAuthorAllFields() {
        return Author.builder()
                .firstName("Victor")
                .lastName("Hugo")
                .idBook(100)
                .build();
    }

    public Author updateAuthorFirstName() {
        return Author.builder()
                .firstName("Victor")
                .build();
    }

    public Author updateAuthorLastName() {
        return Author.builder()
                .lastName("Hugo")
                .build();
    }

    public Map<String, Object> updateAuthorWithInvalidBookIdType() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("idBook", "one hundred");
        return payload;
    }
}
