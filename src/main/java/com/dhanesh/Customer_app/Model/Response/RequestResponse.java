package com.dhanesh.Customer_app.Model.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestResponse {
    private Integer statusCode;
    private String message;
}
