package cn.newshome.Dao.ex;

public class NewsDaoException extends RuntimeException {

	public NewsDaoException() {
		super();
	}

	public NewsDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NewsDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public NewsDaoException(String message) {
		super(message);
	}

	public NewsDaoException(Throwable cause) {
		super(cause);
	}
}
