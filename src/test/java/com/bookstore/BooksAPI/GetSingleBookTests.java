package com.bookstore.BooksAPI;

import com.bookstore.api.BooksAPI;
import com.bookstore.model.Book;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSingleBookTests {
    Book bookResponse = new Book();

    @Test(description = "Get single book")
    public void getSingleBookByID() {
        Response response = BooksAPI.getBookById(1);
        bookResponse = response.as(Book.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(bookResponse.getId(), 1);
        Assert.assertNotNull(bookResponse.getTitle());
    }

    @Test(description = "Get single book with non-existent ID")
    public void getNonExistentBookByID() {
        Response response = BooksAPI.getBookById(900);
        bookResponse = response.as(Book.class);

        Assert.assertEquals(response.getStatusCode(), 404);
        Assert.assertEquals(bookResponse.getStatus(), 404);
//        Assert.assertEquals(bookResponse.getErrorTitle(), "One or more validation errors occurred.");
    }

    @Test(description = "Get single book with invalid format ID")
    public void getSingleBookSearchingByInvalidIdType() {
        Response response = BooksAPI.getBookById("Les Misérables");
        bookResponse = response.as(Book.class);

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(bookResponse.getStatus(), 400);
        Assert.assertTrue(bookResponse.getErrors().get("id")[0].contains("is not valid"));
    }
}
