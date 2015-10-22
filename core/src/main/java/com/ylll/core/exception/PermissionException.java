package com.ylll.core.exception;

/**
 * 用户权限异常 throw new PermissionException("XXXX")
 */
public class PermissionException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 2332608236621015980L;

	private String code;

    /**
     *
     */
    public PermissionException() {
		super();
	}

    /**
     *
     * @param message
     */
    public PermissionException(String message) {
		super(message);
	}

    /**
     *
     * @param code
     * @param message
     */
    public PermissionException(String code, String message) {
		super(message);
		this.code = code;
	}

    /**
     *
     * @param cause
     */
    public PermissionException(Throwable cause) {
		super(cause);
	}

    /**
     *
     * @param message
     * @param cause
     */
    public PermissionException(String message, Throwable cause) {
		super(message, cause);
	}

    /**
     *
     * @param code
     * @param message
     * @param cause
     */
    public PermissionException(String code, String message, Throwable cause) {
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
