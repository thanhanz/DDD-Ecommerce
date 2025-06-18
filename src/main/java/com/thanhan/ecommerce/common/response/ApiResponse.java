package com.thanhan.ecommerce.common.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {

    private String message;
    private int code;
    private T data;

    public static <T> ResponseEntity<ApiResponse<T>> success(String message, T data) {
        ApiResponse<T> response = new ApiResponse<>(message, HttpStatus.OK.value(), data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static <T> ResponseEntity<ApiResponse<T>> error(String message, HttpStatus status, T data) {
        ApiResponse<T> response = new ApiResponse<>(message, status.value(), data);
        return new ResponseEntity<>(response, status);
    }
}
