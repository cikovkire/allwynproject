package com.bookstore.BooksAPI;

import com.bookstore.api.BooksAPI;
import com.bookstore.model.Book;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteBookTests {
    Book bookResponse = new Book();

    @Test(description = "Delete a book by ID")
    public void deleteBookById() {
        Response response = BooksAPI.deleteBook(1);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

//    @Test(description = "Delete a book by ID - Non existent book")
//    public void deleteBookByIdNotFound() {
//        Response response = BooksAPI.deleteBook(900);
//        bookResponse = response.as(Book.class);
//
//        Assert.assertEquals(response.getStatusCode(), 404);
//    }

    @Test(description = "Delete a book by non-numeric ID - Invalid ID Format")
    public void deleteBookByIdInvalidFormat() {
        Response response = BooksAPI.getBookById("Les Misérables");
        bookResponse = response.as(Book.class);

        Assert.assertEquals(response.getStatusCode(), 400);
        Assert.assertEquals(bookResponse.getStatus(), 400);
        Assert.assertTrue(bookResponse.getErrors().get("id")[0].contains("is not valid"));
    }
}
