package model;

public class Player {

	private String Username;
	private String Password;

	public Player(String name, String pass) {
		Username = name;
		Password = pass;

	}

	public String getUsername() {
		return Username;
	}
	
	public String getPassword() {
		return Password;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public boolean isPasswordMatch(String pass) {
		boolean k = false;

		if (Password != null && Password.equals(pass)) {
			k = true;
		}

		return k;

	}
}
