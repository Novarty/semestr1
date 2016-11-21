package pojo;

/**
 * Created by Артем on 27.10.2016.
 */
//import org.apache.log4j.Logger;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by Ilya Evlampiev on 14.10.2015.
 */
public abstract class User {
    List<Topic> electedTopics;
    private static final long serialVersionUID = 1L;
    private int databaseId=-1;
    private String username;
    private String passwordHash;
    private String firstname;
    private String lastname;
    private String role;
    private List<Topic> likedPosts; // список постов, добавленных в избранное
    static Logger log = Logger.getLogger(User.class);

    public User(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public User() {

    }

    public List<Topic> getElectedTopics() {
        return electedTopics;
    }

    public void setElectedTopics(List<Topic> electedTopics) {
        this.electedTopics = electedTopics;
    }
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.passwordHash;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) //throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        /*
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte byteData[] = md.digest();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++)
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        this.passwordHash = sb.toString();
        */
        this.passwordHash=password;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public static boolean isBetween(int x, int lower, int upper) {
//        return lower <= x && x <= upper;
//    }

    public int getDatabaseId()
    {
        return this.databaseId;
    }

    public void setDatabaseId(int id)
    {
        this.databaseId=id;
    }

    public boolean isYou(User sessionUser)
    {
        log.info(this.getUsername()+" is checked the session user "+sessionUser.getUsername()+" the same or not ");
        return this.getDatabaseId()==sessionUser.getDatabaseId();
    }

//    public boolean isConfirmed() {
//        return confirmed;
//    }
    public abstract boolean isMember();
    public abstract boolean isModerator();
    public abstract boolean isAdmin();

    public List<Topic> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(List<Topic> likedPosts) {
        this.likedPosts = likedPosts;
    }
}
