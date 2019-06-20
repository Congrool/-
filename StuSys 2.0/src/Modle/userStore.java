package Modle;

public class userStore {
	private String passwd;
	private String username;
	public userStore(String usern, String pa) {
		passwd = pa;
		username = usern;
	}
	public String getpassword() {
		return passwd;
	}
	public String getusername() {
		return username;
	}
}
