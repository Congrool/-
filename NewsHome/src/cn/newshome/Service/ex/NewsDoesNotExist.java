package cn.newshome.Service.ex;

public class NewsDoesNotExist extends Exception {

	public NewsDoesNotExist() {
		super();
	}

	public NewsDoesNotExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NewsDoesNotExist(String message, Throwable cause) {
		super(message, cause);
	}

	public NewsDoesNotExist(String message) {
		super(message);
	}

	public NewsDoesNotExist(Throwable cause) {
		super(cause);
	}
}
