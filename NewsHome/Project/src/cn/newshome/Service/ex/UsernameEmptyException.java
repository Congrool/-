package cn.newshome.Service.ex;

public class UsernameEmptyException extends Exception {

	public UsernameEmptyException() {
	}

	public UsernameEmptyException(String message) {
		super(message);
	}

	public UsernameEmptyException(Throwable cause) {
		super(cause);
	}

	public UsernameEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameEmptyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
