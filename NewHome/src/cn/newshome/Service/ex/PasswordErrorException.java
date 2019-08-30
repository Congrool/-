package cn.newshome.Service.ex;

public class PasswordErrorException extends Exception {

	public PasswordErrorException() {
	}

	public PasswordErrorException(String message) {
		super(message);
	}

	public PasswordErrorException(Throwable cause) {
		super(cause);
	}

	public PasswordErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordErrorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
