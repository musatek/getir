package com.getir.exception;

public class NewStockCannotBiggerThanOldStockException extends RuntimeException{

    public NewStockCannotBiggerThanOldStockException() {
        super();
    }

    public NewStockCannotBiggerThanOldStockException(String message) {
        super(message);
    }
}