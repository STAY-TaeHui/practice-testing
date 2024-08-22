package com.example.cafekiosk.spring.api;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiResponse<T>
{
    private int code;
    private HttpStatus status;
    private String message;
    private T data;

    public ApiResponse(HttpStatus status, String message, T data)
    {
        this.code = status.value();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /*
    * Response의 규격은 프론트/백엔드에서 정하기 나름
    * */
    public static <T> ApiResponse<T> of(HttpStatus httpStatus, String message, T data)
    {
        return new ApiResponse<>(httpStatus, message, data);
    }

    public static <T> ApiResponse<T> of(HttpStatus httpStatus, T data)
    {
        return new ApiResponse<>(httpStatus, httpStatus.name(), data);
    }

    public static <T> ApiResponse<T> ok(T data)
    {
        return of(HttpStatus.OK, data);
    }
}
