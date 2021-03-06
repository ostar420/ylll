package com.ylll.core.exception;

/**
 * 自定义异常处理,描述类..throw new ParameterException("XXXX")
 */

public class ParameterException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 6417641452178955756L;

    /**
     *
     */
    public ParameterException() {
		super();
	}

    /**
     *
     * @param message
     */
    public ParameterException(String message) {
		super(message);
	}

    /**
     *
     * @param cause
     */
    public ParameterException(Throwable cause) {
		super(cause);
	}

    /**
     *
     * @param message
     * @param cause
     */
    public ParameterException(String message, Throwable cause) {
		super(message, cause);
	}
}
