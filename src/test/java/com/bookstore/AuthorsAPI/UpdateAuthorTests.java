package com.bookstore.AuthorsAPI;

import com.bookstore.api.AuthorsAPI;
import com.bookstore.model.Author;
import com.bookstore.payloads.UpdateAuthorPayload;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class UpdateAuthorTests {
    Author updatedAuthor = new Author();
    UpdateAuthorPayload updateAuthorPayload = new UpdateAuthorPayload();
    Author authorResponse = new Author();
    Map<String, Object> invalidPayload;

    @Test(description = "Update an author")
    public void updateAuthor() {
        updatedAuthor = updateAuthorPayload.updateAuthorAllFields();

        Response response = AuthorsAPI.updateAuthor(1, updatedAuthor);
        authorResponse = response.as(Author.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(authorResponse.getFirstName(), updatedAuthor.getFirstName());
        Assert.assertEquals(authorResponse.getLastName(), updatedAuthor.getLastName());
        Assert.assertEquals(authorResponse.getIdBook(), updatedAuthor.getIdBook());
    }

    @Test(description = "Update the first name of an author")
    public void updateFirstNameOfAuthor() {
        updatedAuthor = updateAuthorPayload.updateAuthorFirstName();

        Response response = AuthorsAPI.updateAuthor(1, updatedAuthor);
        authorResponse = response.as(Author.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(authorResponse.getFirstName(), updatedAuthor.getFirstName());
    }

    @Test(description = "Update idBook of an author with invalid type")
    public void updateAuthorWithInvalidIdBookType() {
        invalidPayload = updateAuthorPayload.updateAuthorWithInvalidBookIdType();

        Response response = AuthorsAPI.updateAuthor(1, invalidPayload);
        authorResponse = response.as(Author.class);

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(authorResponse.getStatus(), 400);
    }

    @Test(description = "Update author by searching by invalid id type")
    public void updateAuthorSearchingByInvalidIdType() {
        updatedAuthor = updateAuthorPayload.updateAuthorFirstName();

        Response response = AuthorsAPI.updateAuthor("VictorHugo", updatedAuthor);
        authorResponse = response.as(Author.class);

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(authorResponse.getStatus(), 400);
        Assert.assertTrue(authorResponse.getErrors().get("id")[0].contains("is not valid"));
    }
}
