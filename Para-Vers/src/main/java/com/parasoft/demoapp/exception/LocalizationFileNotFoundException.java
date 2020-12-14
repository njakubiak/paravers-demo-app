package com.parasoft.demoapp.exception;

public class LocalizationFileNotFoundException extends Exception{

	private static final long serialVersionUID = 4018926015763789277L;

	public LocalizationFileNotFoundException(String message) {
        super(message);
    }

    public LocalizationFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
