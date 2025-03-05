package com.bookstore.model;

import com.bookstore.model.response.APIResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author extends APIResponse {
    private int id;
    private int idBook;
    private String firstName;
    private String lastName;
    private String nationality;
}
