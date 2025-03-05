package com.bookstore.AuthorsAPI;

import com.bookstore.api.AuthorsAPI;
import com.bookstore.model.Author;
import com.bookstore.model.Book;
import com.bookstore.payloads.PostNewAuthorPayload;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class PostAuthorTests {
    PostNewAuthorPayload newAuthorPayload = new PostNewAuthorPayload();
    Author newAuthor = new Author();
    Author authorResponse = new Author();
    Map<String, Object> invalidPayload;

    @Test()
    public void postAuthor() {
        newAuthor = newAuthorPayload.createAuthor();

        Response response = AuthorsAPI.addAuthor(newAuthor);
        authorResponse = response.as(Author.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(authorResponse.getFirstName(), newAuthor.getFirstName());
        Assert.assertEquals(authorResponse.getLastName(), newAuthor.getLastName());
        Assert.assertEquals(authorResponse.getIdBook(), newAuthor.getIdBook());
    }

    @Test(description = "Post author without first name")
    public void postAuthorWithoutFirstName() {
        newAuthor = newAuthorPayload.createAuthorWithoutFirstName();

        Response response = AuthorsAPI.addAuthor(newAuthor);
        authorResponse = response.as(Author.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(authorResponse.getLastName(), newAuthor.getLastName());
        Assert.assertNull(authorResponse.getFirstName());
    }

    @Test(description = "Post author without last name")
    public void postAuthorWithoutLastName() {
        newAuthor = newAuthorPayload.createAuthorWithoutLastName();

        Response response = AuthorsAPI.addAuthor(newAuthor);
        authorResponse = response.as(Author.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(authorResponse.getFirstName(), newAuthor.getFirstName());
        Assert.assertNull(authorResponse.getLastName());
    }

    @Test(description = "Post author with invalid type for book ID")
    public void postAuthorWithInvalidTypeForBookId() {
        invalidPayload = newAuthorPayload.createAuthorWithInvalidBookIdType();

        Response response = AuthorsAPI.addAuthor(invalidPayload);
        authorResponse = response.as(Author.class);

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(authorResponse.getStatus(), 400);
//    Assert.assertEquals(authorResponse.getErrorTitle(), "One or more validation errors occurred.");
    }

}
