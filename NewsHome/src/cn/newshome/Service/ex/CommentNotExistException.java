package cn.newshome.Service.ex;

public class CommentNotExistException extends Exception {

	public CommentNotExistException() {
	}

	public CommentNotExistException(String message) {
		super(message);
	}

	public CommentNotExistException(Throwable cause) {
		super(cause);
	}

	public CommentNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommentNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
