package com.getir.model.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    private String exceptionMessage;
    private String description;
    HttpStatus status;
    LocalDateTime timestamp;

    @Override
    public String toString() {
        return "ApiError{" +
                "exceptionMessage='" + exceptionMessage + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", timestamp=" + timestamp +
                '}';
    }
}
