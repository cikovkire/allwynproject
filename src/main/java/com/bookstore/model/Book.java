package com.bookstore.model;

import com.bookstore.model.response.APIResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book extends APIResponse {
    private int id;
    @JsonProperty("title")
    private String title;
    private String description;
    private int pageCount;
    private String excerpt;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String publishDate;
}
