package com.example.devsupport.common.dto.response;

import java.util.List;
import java.time.OffsetDateTime;

// エラーレスポンスを表すDTO
public record ErrorResponse(String code, String message, List<ErrorDetail> details, OffsetDateTime timestamp) {
}
