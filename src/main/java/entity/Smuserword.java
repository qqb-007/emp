package entity;

import java.util.Objects;

public class Smuserword {
    private int id;
    private String word;
    private int up;
    private int down;
    private int userid;
    private String username;

    public Smuserword() {
    }

    public Smuserword(int id, String word, int up, int down, int userid, String username) {
        this.id = id;
        this.word = word;
        this.up = up;
        this.down = down;
        this.userid = userid;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getUp() {
        return up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return down;
    }

    public void setDown(int down) {
        this.down = down;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smuserword that = (Smuserword) o;
        return id == that.id &&
                up == that.up &&
                down == that.down &&
                userid == that.userid &&
                Objects.equals(word, that.word) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word, up, down, userid, username);
    }

    @Override
    public String toString() {
        return "Smuserword{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", up=" + up +
                ", down=" + down +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                '}';
    }
}
