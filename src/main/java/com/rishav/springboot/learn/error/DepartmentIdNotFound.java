package com.rishav.springboot.learn.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class DepartmentIdNotFound extends Exception{
    public DepartmentIdNotFound() {
    }

    public DepartmentIdNotFound(String message) {
        super(message);
    }

    public DepartmentIdNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public DepartmentIdNotFound(Throwable cause) {
        super(cause);
    }

    public DepartmentIdNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
