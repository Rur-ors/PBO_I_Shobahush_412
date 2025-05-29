package Modul4.UserEditor;

public abstract class User4 {
    protected String username;
    protected String password;

    public User4(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public abstract boolean login(String inputUsername, String inputPassword);
    public abstract void displayAppMenu();
}
