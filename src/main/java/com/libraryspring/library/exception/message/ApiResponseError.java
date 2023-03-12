package com.libraryspring.library.exception.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiResponseError {

    private HttpStatus status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;

    private String message;

    private String requestURL;


    // GETTER & SETTER

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequestURL() {
        return requestURL;
    }

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }


    // Const

    private ApiResponseError(){
        timestamp = LocalDateTime.now();
    }

    public ApiResponseError(HttpStatus status){
        this();
        this.status = status;
        this.message = "Unexpected error";
    }

    public ApiResponseError(HttpStatus status, String message, String requestURL){
        this(status);
        this.message = message;
        this.requestURL = requestURL;
    }
}
