package masterticket.models;


public class Authenticator {

	public String authenticate(String username, String password) {
		if (("prasad".equalsIgnoreCase(username))
				&& ("password".equals(password))) {
			return "success";
		} else {
			return "failure";
		}
	}
}