import java.util.ArrayList;

public class User extends Main{


    private String userName;
    private String password;
    private ArrayList<User> users;

    public User(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }

    public void addUsers(User e){
        users.add(e);
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    public boolean login(String username, String password){
        for (User u : users){
            if(u.getUserName() == username && u.getPassword() == password){
                return true;
            }

        }
        return false;
    }
}
