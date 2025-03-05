package com.bookstore.api;

import com.bookstore.model.Author;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class AuthorsAPI {

    private static final String BASE_URL = "https://fakerestapi.azurewebsites.net/api/v1";

    public static Response getAllAuthors() {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .get("Authors");
    }

    public static Response getAuthorById(int id) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("id", id)
                .get("Authors/{id}");
    }

    public static Response getAuthorById(String id) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("id", id)
                .get("Authors/{id}");
    }

    public static Response addAuthor(Author author) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(author)
                .post("Authors");
    }

    public static Response addAuthor(Map<String, Object> payload) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(payload)
                .post("Authors");
    }

    public static Response updateAuthor(int id, Author author) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("id", id)
                .contentType("application/json")
                .body(author)
                .put("Authors/{id}");
    }

    public static Response updateAuthor(String id, Author author) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("id", id)
                .contentType("application/json")
                .body(author)
                .put("Authors/{id}");
    }

    public static Response updateAuthor(int id, Map<String, Object> payload) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("id", id)
                .contentType("application/json")
                .body(payload)
                .put("Authors/{id}");
    }

    public static Response deleteAuthor(int id) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("id", id)
                .delete("Authors/{id}");
    }

    public static Response deleteAuthor(String id) {
        return RestAssured.given()
                .baseUri(BASE_URL)
                .pathParam("id", id)
                .delete("Authors/{id}");
    }
}
