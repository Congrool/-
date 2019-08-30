package cn.newshome.Dao.ex;

public class UserDaoException extends RuntimeException {

	public UserDaoException() {
		super();
	}

	public UserDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDaoException(String message) {
		super(message);
	}

	public UserDaoException(Throwable cause) {
		super(cause);
	}
	
}
