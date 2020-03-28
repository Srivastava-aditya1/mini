package net.javaguides.registration.model;


public class Employee  {
    
	private int uniroll;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    
    public int getuniroll() {
        return uniroll;
    }
    public void setuniroll(int uniroll) {
        this.uniroll = uniroll;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
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