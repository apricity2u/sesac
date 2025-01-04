package com.example.demo.myjpasite4.exceptions;

import com.example.demo.myjpasite4.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

// 전역에 대한 예외처리를 해줌
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error("resoure not found", "NOT_FOUND"));
                // .body(ApiResponse.error(ex.getMessage(), "NOT_FOUND"));
    }

    // 없는 url로 접속했을 때 뜨는 에러
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleNotFound(NoHandlerFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiResponse.error(
                                "요청한 리소스를 찾을 수 없습니다: " + ex.getRequestURL(),
                                "NOT_FOUND"
                        ));
    }

    // 각 url에 매핑되는 method가 없을 때 뜨는 에러
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponse<Void>> handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex) {
        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(ApiResponse.error("Method Not Allowed", "Method Not Allowed"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Object>> handleValidationException(
            MethodArgumentNotValidException ex
    ) {
        // 모든 검증 오류 수집
        Map<String, String> errors = new HashMap<>();

        // exception에서 에러들의 모음집을 뽑아옴
        ex.getBindingResult()
                .getFieldErrors()
                // 여러개를 반복을 돌면서
                .forEach(error ->
                        // errors에 담아줌
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        )
                );

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.error(
                        "입력값 검증에 실패했습니다.",
                        "INVALID_INPUT",
                        errors
                ));
    }
}
