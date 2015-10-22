package com.ylll.core.exception;

/**
 * 系统业务异常 throw new SystemException("XXXX")
 */
public class SystemException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 2332608236621015980L;

	private String code;

    /**
     *
     */
    public SystemException() {
		super();
	}

    /**
     *
     * @param message
     */
    public SystemException(String message) {
		super(message);
	}

    /**
     *
     * @param code
     * @param message
     */
    public SystemException(String code, String message) {
		super(message);
		this.code = code;
	}

    /**
     *
     * @param cause
     */
    public SystemException(Throwable cause) {
		super(cause);
	}

    /**
     *
     * @param message
     * @param cause
     */
    public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

    /**
     *
     * @param code
     * @param message
     * @param cause
     */
    public SystemException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

    /**
     *
     * @return
     */
    public String getCode() {
		return code;
	}

    /**
     *
     * @param code
     */
    public void setCode(String code) {
		this.code = code;
	}

}
