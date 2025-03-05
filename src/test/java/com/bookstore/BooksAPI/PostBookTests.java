package com.bookstore.BooksAPI;

import com.bookstore.api.BooksAPI;
import com.bookstore.model.Book;
import com.bookstore.payloads.PostNewBookPayload;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class PostBookTests {
    PostNewBookPayload newBookPayload = new PostNewBookPayload();
    Book newBook = new Book();
    Book bookResponse = new Book();
    Map<String, Object> invalidPayload;

    @Test(description = "Post a book")
    public void postBookTest() {
        newBook = newBookPayload.createBook();

        Response response = BooksAPI.addBook(newBook);
        bookResponse = response.as(Book.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(bookResponse.getTitle(), newBook.getTitle());
        Assert.assertEquals(bookResponse.getDescription(), newBook.getDescription());
        Assert.assertEquals(bookResponse.getPageCount(), newBook.getPageCount());
        Assert.assertEquals(bookResponse.getExcerpt(), newBook.getExcerpt());
    }

    @Test(description = "Post book without page count")
    public void postBookWithoutPageCount() {
        newBook = newBookPayload.createBookWithoutPageCount();

        Response response = BooksAPI.addBook(newBook);
        bookResponse = response.as(Book.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(bookResponse.getTitle(), newBook.getTitle());
        Assert.assertEquals(bookResponse.getDescription(), newBook.getDescription());
        Assert.assertEquals(bookResponse.getPageCount(), 0);
    }

    @Test(description = "Post book without description")
    public void postBookWithoutDescription() {
        newBook = newBookPayload.createBookWithoutDescription();

        Response response = BooksAPI.addBook(newBook);
        bookResponse = response.as(Book.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(bookResponse.getTitle(), newBook.getTitle());
        Assert.assertNull(bookResponse.getDescription());
    }

    @Test(description = "Post book with invalid type for page count")
    public void postBookWithInvalidTypeForPageCount() {
        invalidPayload = newBookPayload.createBookWithInvalidPageCountType();

        Response response = BooksAPI.addBook(invalidPayload);
        bookResponse = response.as(Book.class);

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(bookResponse.getStatus(), 400);
//        Assert.assertEquals(bookResponse.getErrorTitle(), "One or more validation errors occurred.");
    }

}
