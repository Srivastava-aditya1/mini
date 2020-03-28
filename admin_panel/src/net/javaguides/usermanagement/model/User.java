package net.javaguides.usermanagement.model;

public class User {
	protected int uniroll;
    protected String first_name;
    protected String last_name;
    protected String username;
    protected String password;
    
	public User() {
	}
	
	public User(String first_name, String last_name, String username,String password) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password=password;
	}

	public User(int uniroll, String first_name, String last_name,String username, String password) {
		super();
		this.uniroll=uniroll;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password=password;
	}

	public int getuniroll() {
        return uniroll;
    }
    public void setuniroll(int uniroll) {
        this.uniroll = uniroll;
    }
    public String getfirst_name() {
        return first_name;
    }
    public void setfirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getlast_name() {
        return last_name;
    }
    public void setlast_name(String last_name) {
        this.last_name = last_name;
    }
    public String getusername() {
        return username;
    }
    public void setusername(String username) {
        this.username = username;
    }
    public String getpassword() {
        return password;
    }
    public void setpassword(String password) {
        this.password = password;
    }
}
