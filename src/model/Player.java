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

	public void setUsername(String username) {
		Username = username;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public boolean isPasswordMatch(String str) {
		boolean k = false;

		if (Password != null && Password.equals(str)) {
			k = true;
		}

		return k;

	}
}
