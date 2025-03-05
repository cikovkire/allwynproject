package com.bookstore.AuthorsAPI;

import com.bookstore.api.AuthorsAPI;
import com.bookstore.model.Author;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllAuthorsTests {

    @Test
    public void getAllAuthors() {
        Response response = AuthorsAPI.getAllAuthors();
        List<Author> authors = response.jsonPath().getList("", Author.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertFalse(authors.isEmpty());
    }
}
