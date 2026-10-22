package com.example.devsupport.exception;

import java.util.List;
import java.time.OffsetDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler; // 例外を処理するためのアノテーション
import org.springframework.web.bind.annotation.RestControllerAdvice; // Controller全体に対して例外処理を適用するためのアノテーション

import com.example.devsupport.common.dto.response.ErrorResponse; // エラーレスポンスのDTO

// 共通例外ハンドラ
@RestControllerAdvice // Controller全体に対して例外処理を適用するためのアノテーション
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class) // ResourceNotFoundExceptionがThrowされた場合にこのメソッドが呼ばれる
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(404) // HTTPステータスコード404を返す
                .body(new ErrorResponse("RESOURCE_NOT_FOUND", ex.getMessage(), List.of(), OffsetDateTime.now())); // DTO本文にErrorResponseを設定し、ResponseEntityを返す
    }
}
