package com.bookstore.BooksAPI;

import com.bookstore.api.BooksAPI;
import com.bookstore.model.Book;
import com.bookstore.payloads.UpdateBookPayload;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class UpdateBookTests {
    Book updatedBook = new Book();
    UpdateBookPayload updateBookPayload = new UpdateBookPayload();
    Book bookResponse = new Book();
    Map<String, Object> invalidPayload;

    @Test(description = "Update a book")
    public void updateBook() {
        updatedBook = updateBookPayload.updateBookAllFields();

        Response response = BooksAPI.updateBook(1, updatedBook);
        bookResponse = response.as(Book.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(bookResponse.getTitle(), updatedBook.getTitle());
        Assert.assertEquals(bookResponse.getDescription(), updatedBook.getDescription());
        Assert.assertEquals(bookResponse.getPageCount(), updatedBook.getPageCount());
        Assert.assertEquals(bookResponse.getExcerpt(), updatedBook.getExcerpt());
    }

    @Test(description = "Update the title of a book")
    public void updateTitleOfBook() {
        updatedBook = updateBookPayload.updateBookTitle();

        Response response = BooksAPI.updateBook(1, updatedBook);
        bookResponse = response.as(Book.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(bookResponse.getTitle(), updatedBook.getTitle());
    }

    @Test(description = "Update page count of book with invalid type")
    public void updateBookWithInvalidPageCountType() {
        invalidPayload = updateBookPayload.updateBookWithInvalidPageCountType();

        Response response = BooksAPI.updateBook(1, invalidPayload);
        bookResponse = response.as(Book.class);

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(bookResponse.getStatus(), 400);
    }

    @Test(description = "Update book by searching by invalid id type")
    public void updateBookSearchingByInvalidIdType() {
        updatedBook = updateBookPayload.updateBookTitle();

        Response response = BooksAPI.updateBook("Les Misérables", updatedBook);
        bookResponse = response.as(Book.class);

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(bookResponse.getStatus(), 400);
        Assert.assertTrue(bookResponse.getErrors().get("id")[0].contains("is not valid"));
    }
}
