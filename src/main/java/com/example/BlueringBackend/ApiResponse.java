package com.example.BlueringBackend;

public class ApiResponse<T> {
    private boolean success;
    private String message;
    private T returnField;

    // Constructor, getters, and setters
    public ApiResponse() {
        // Default constructor
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getReturnField() {
        return returnField;
    }

    public void setReturnField(T returnField) {
        this.returnField = returnField;
    }
}
