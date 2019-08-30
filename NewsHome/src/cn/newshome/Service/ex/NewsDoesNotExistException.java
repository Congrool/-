package cn.newshome.Service.ex;

public class NewsDoesNotExistException extends Exception {

	public NewsDoesNotExistException() {
	}

	public NewsDoesNotExistException(String message) {
		super(message);
	}

	public NewsDoesNotExistException(Throwable cause) {
		super(cause);
	}

	public NewsDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public NewsDoesNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
