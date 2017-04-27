
public class userEntry {

	private String username;
    private String password;

    //constructor
    public userEntry(String name, String pw){
    	username = name;
    	password = pw;
    }
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
