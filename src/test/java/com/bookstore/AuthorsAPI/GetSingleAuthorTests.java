package com.bookstore.AuthorsAPI;

import com.bookstore.api.AuthorsAPI;
import com.bookstore.api.BooksAPI;
import com.bookstore.model.Author;
import com.bookstore.model.Book;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleAuthorTests {
    Author authorResponse = new Author();

    @Test(description = "Get single author")
    public void getSingleAuthorById() {
        Response response = AuthorsAPI.getAuthorById(1);
        authorResponse = response.as(Author.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(authorResponse.getId(), 1);
        Assert.assertNotNull(authorResponse.getFirstName());
        Assert.assertNotNull(authorResponse.getLastName());
    }

    @Test(description = "Get single author")
    public void getNonExistentAuthorById() {
        Response response = AuthorsAPI.getAuthorById(999);
        authorResponse = response.as(Author.class);

        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertEquals(authorResponse.getStatus(), 404);
//        Assert.assertEquals(authorResponse.getErrorTitle(), "One or more validation errors occurred.");
    }

    @Test(description = "Get single author")
    public void getSingleAuthorBySearchingByInvalidIdType() {
        Response response = AuthorsAPI.getAuthorById("Blazhe Konevski");
        authorResponse = response.as(Author.class);

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(authorResponse.getStatus(), 400);
        Assert.assertTrue(authorResponse.getErrors().get("id")[0].contains("is not valid"));
    }
}
