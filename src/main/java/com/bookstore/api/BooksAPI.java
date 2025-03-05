package com.bookstore.api;

import com.bookstore.model.Book;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class BooksAPI {
    private static final String BASE_URL = "https://fakerestapi.azurewebsites.net/api/v1";

    public static Response getAllBooks() {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .get("Books");
    }

    public static Response getBookById(int id) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("id", id)
                .get("Books/{id}");
    }

    public static Response getBookById(String id) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("id", id)
                .get("Books/{id}");
    }

    public static Response addBook(Book book) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(book)
                .post("Books");
    }

    public static Response addBook(Map<String, Object> payload) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(payload)
                .post("Books");
    }

    public static Response updateBook(int id, Book book) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("id", id)
                .contentType("application/json")
                .body(book)
                .put("Books/{id}");
    }

    public static Response updateBook(String id, Book book) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("id", id)
                .contentType("application/json")
                .body(book)
                .put("Books/{id}");
    }

    public static Response updateBook(int id, Map<String, Object> payload) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("id", id)
                .contentType("application/json")
                .body(payload)
                .put("Books/{id}");
    }

    public static Response deleteBook(int id) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("id", id)
                .delete("Books/{id}");
    }

    public static Response deleteBook(String id) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("id", id)
                .delete("Books/{id}");
    }
}
