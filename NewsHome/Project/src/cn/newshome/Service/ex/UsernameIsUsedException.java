package cn.newshome.Service.ex;

public class UsernameIsUsedException extends Exception {

	public UsernameIsUsedException() {
	}

	public UsernameIsUsedException(String message) {
		super(message);
	}

	public UsernameIsUsedException(Throwable cause) {
		super(cause);
	}

	public UsernameIsUsedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernameIsUsedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
