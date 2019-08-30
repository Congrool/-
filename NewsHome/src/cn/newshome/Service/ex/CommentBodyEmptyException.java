package cn.newshome.Service.ex;

public class CommentBodyEmptyException extends Exception {

	public CommentBodyEmptyException() {
		super();
	}

	public CommentBodyEmptyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CommentBodyEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommentBodyEmptyException(String message) {
		super(message);
	}

	public CommentBodyEmptyException(Throwable cause) {
		super(cause);
	}
	
}
