package entity;

import java.util.Objects;

public class Admin {
    private int id;
    private String username;
    private String name;
    private String password;
    private String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return id == admin.id &&
                Objects.equals(username, admin.username) &&
                Objects.equals(name, admin.name) &&
                Objects.equals(password, admin.password) &&
                Objects.equals(sex, admin.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, name, password, sex);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Admin(int id, String username, String name, String password, String sex) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.sex = sex;
    }

    public Admin() {
    }
}
