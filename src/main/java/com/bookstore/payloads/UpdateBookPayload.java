package com.bookstore.payloads;

import com.bookstore.model.Book;

import java.util.HashMap;
import java.util.Map;

public class UpdateBookPayload {
    public Book updateBookAllFields() {
        return Book.builder()
                .title("Les Misérables")
                .description("Best book ever")
                .pageCount(200)
                .excerpt("French epic historical novel by Victor Hugo, that is considered one of the greatest novels of the 19th century.")
                .publishDate("1862-03-31")
                .build();
    }

    public Book updateBookTitle() {
        return Book.builder()
                .title("Les Misérables")
                .build();
    }

    public Book updateBookDescription() {
        return Book.builder()
                .description("Best book ever")
                .build();
    }

    public Map<String, Object> updateBookWithInvalidPageCountType(){
        Map<String, Object> payload = new HashMap<>();
        payload.put("pageCount", "two hundred"); // Invalid data type (string instead of int)
        return payload;
    }
}
