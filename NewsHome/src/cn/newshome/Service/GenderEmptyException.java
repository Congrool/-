package cn.newshome.Service;

public class GenderEmptyException extends Exception {

	public GenderEmptyException() {
		super();
	}

	public GenderEmptyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GenderEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenderEmptyException(String message) {
		super(message);
	}

	public GenderEmptyException(Throwable cause) {
		super(cause);
	}

}
