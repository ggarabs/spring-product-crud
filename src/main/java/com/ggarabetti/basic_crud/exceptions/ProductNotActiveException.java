package com.ggarabetti.basic_crud.exceptions;

public class ProductNotActiveException extends RuntimeException {
    public ProductNotActiveException() {
        super("O produto foi depreciado e não está mais ativo!");
    }

    public ProductNotActiveException(String message) {
        super(message);
    }
}
