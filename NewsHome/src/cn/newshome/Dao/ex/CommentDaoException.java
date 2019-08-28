package cn.newshome.Dao.ex;

public class CommentDaoException extends RuntimeException {

	public CommentDaoException() {
		super();
	}

	public CommentDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CommentDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommentDaoException(String message) {
		super(message);
	}

	public CommentDaoException(Throwable cause) {
		super(cause);
	}

}
