package com.bookstore.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse {
    private String type;
    @JsonProperty("title") // this field the description error should not be named title by any means
    private String errorTitle;
    private int status;
    private String traceId;
    private Map<String, String[]> errors;
}
