package cn.newshome.Service.ex;

public class PasswordEmptyException extends Exception {

	public PasswordEmptyException() {
	}

	public PasswordEmptyException(String message) {
		super(message);
	}

	public PasswordEmptyException(Throwable cause) {
		super(cause);
	}

	public PasswordEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordEmptyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
