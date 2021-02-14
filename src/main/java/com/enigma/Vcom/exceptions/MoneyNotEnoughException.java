package com.enigma.Vcom.exceptions;

import org.springframework.http.HttpStatus;

public class MoneyNotEnoughException extends ApplicationException{

    public MoneyNotEnoughException() {
        super(HttpStatus.NOT_FOUND, "error." + HttpStatus.NOT_FOUND.value() + ".poor");
    }
}
