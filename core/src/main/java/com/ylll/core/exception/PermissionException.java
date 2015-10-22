package com.ylll.core.exception;

/**
 * 用户权限异常 throw new PermissionException("XXXX")
 */
public class PermissionException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 2332608236621015980L;

	private String code;

	public PermissionException() {
		super();
	}

	public PermissionException(String message) {
		super(message);
	}

	public PermissionException(String code, String message) {
		super(message);
		this.code = code;
	}

	public PermissionException(Throwable cause) {
		super(cause);
	}

	public PermissionException(String message, Throwable cause) {
		super(message, cause);
	}

	public PermissionException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
