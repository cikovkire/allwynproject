package com.bookstore.BooksAPI;

import com.bookstore.api.BooksAPI;
import com.bookstore.model.Book;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GetAllBooksTests {

    @Test(description = "Get all books")
    public void getAllBooks() {
        Response response = BooksAPI.getAllBooks();
        List<Book> books = response.jsonPath().getList("", Book.class);

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertFalse(books.isEmpty());
    }
}
