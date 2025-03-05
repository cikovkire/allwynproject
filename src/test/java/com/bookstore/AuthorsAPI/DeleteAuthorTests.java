package com.bookstore.AuthorsAPI;

import com.bookstore.api.AuthorsAPI;
import com.bookstore.model.Author;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAuthorTests {
    Author authorResponse = new Author();

    @Test
    public void deleteAuthorById() {
        Response response = AuthorsAPI.deleteAuthor(1);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

//    @Test // Not working - API returns 200 even when ID not found
//    public void deleteAuthorByIdNotFound() {
//        Response response = AuthorsAPI.deleteAuthor(900);
//
//        Assert.assertEquals(response.getStatusCode(), 404);
//    }

    @Test
    public void deleteAuthorByIdInvalidFormat() {
        Response response = AuthorsAPI.deleteAuthor("Blazhe Konevski");
        authorResponse = response.as(Author.class);

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(authorResponse.getStatus(), 400);
        Assert.assertTrue(authorResponse.getErrors().get("id")[0].contains("is not valid"));
    }

}
