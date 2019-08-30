package cn.newshome.Service.ex;

public class StringEmptyException extends Exception {

	public StringEmptyException() {
	}

	public StringEmptyException(String message) {
		super(message);
	}

	public StringEmptyException(Throwable cause) {
		super(cause);
	}

	public StringEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public StringEmptyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
