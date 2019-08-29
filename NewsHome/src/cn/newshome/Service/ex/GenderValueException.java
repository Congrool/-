package cn.newshome.Service.ex;

public class GenderValueException extends Exception {

	public GenderValueException() {
	}

	public GenderValueException(String message) {
		super(message);
	}

	public GenderValueException(Throwable cause) {
		super(cause);
	}

	public GenderValueException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenderValueException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
