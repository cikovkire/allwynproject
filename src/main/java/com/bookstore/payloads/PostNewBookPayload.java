package com.bookstore.payloads;

import com.bookstore.model.Book;

import java.util.HashMap;
import java.util.Map;

public class PostNewBookPayload {

    public Book createBook() {
        return Book.builder()
                .title("Les Misérables")
                .description("Best book ever")
                .pageCount(200)
                .excerpt("French epic historical novel by Victor Hugo, that is considered one of the greatest novels of the 19th century.")
                .publishDate("1862-03-31")
                .build();

    }

    public Book createBookWithoutPageCount() {
        return Book.builder()
                .title("Les Misérables")
                .description("Best book ever")
                .excerpt("French epic historical novel by Victor Hugo, that is considered one of the greatest novels of the 19th century.")
                .publishDate("1862-03-31")
                .build();
    }

    public Book createBookWithoutDescription() {
        return Book.builder()
                .title("Les Misérables")
                .pageCount(200)
                .excerpt("French epic historical novel by Victor Hugo, that is considered one of the greatest novels of the 19th century.")
                .publishDate("1862-03-31")
                .build();

    }

    public Map<String, Object> createBookWithInvalidPageCountType(){
        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "Invalid Book");
        payload.put("description", "This book has invalid data types");
        payload.put("pageCount", "two hundred"); // Invalid data type (string instead of int)
        payload.put("excerpt", "Sample excerpt");
        payload.put("publishDate", "2023-10-01");
        return payload;
    }


}
