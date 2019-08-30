package cn.newshome.Service.ex;

public class UsernameContainsillegalCharacterException extends Exception {

	public UsernameContainsillegalCharacterException() {
		super();
	}

	public UsernameContainsillegalCharacterException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UsernameContainsillegalCharacterException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameContainsillegalCharacterException(String message) {
		super(message);
	}

	public UsernameContainsillegalCharacterException(Throwable cause) {
		super(cause);
	}

}
