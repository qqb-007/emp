package entity;

public class User {
    private int id;
    private String username;
    private String password;
    private double salary;
    private int age;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password="
                + password + ", salary=" + salary + ", age=" + age + "]";
    }
    public User(int id, String username, String password, double salary, int age) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.salary = salary;
        this.age = age;
    }
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

}

