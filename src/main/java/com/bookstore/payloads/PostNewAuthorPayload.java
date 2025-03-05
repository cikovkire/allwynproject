package com.bookstore.payloads;

import com.bookstore.model.Author;

import java.util.HashMap;
import java.util.Map;

public class PostNewAuthorPayload {

    public Author createAuthor() {
        return Author.builder()
                .idBook(100) // Assuming this links the author to a book
                .firstName("Victor")
                .lastName("Hugo")
                .build();
    }

    public Author createAuthorWithoutFirstName() {
        return Author.builder()
                .lastName("Hugo")
                .idBook(100)
                .build();
    }

    public Author createAuthorWithoutLastName() {
        return Author.builder()
                .firstName("Victor")
                .idBook(100)
                .build();
    }

    public Map<String, Object> createAuthorWithInvalidBookIdType() {
        Map<String, Object> payload = new HashMap<>();
        payload.put("firstName", "Victor");
        payload.put("lastName", "Hugo");
        payload.put("idBook", "one hundred");
        return payload;
    }

}
