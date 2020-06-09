package dev.naman.interviewbitclone.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseDto<T> {

    private HttpStatus statusCode;
    private T data;

    public ResponseDto(HttpStatus httpStatus, T data) {
        this.statusCode = httpStatus;
        this.data = data;
    }

}
