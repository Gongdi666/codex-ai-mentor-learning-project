package com.example.devsupport.exception;

// リソースが見つからない場合にThrowされる例外
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
