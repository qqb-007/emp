package service;

import entity.User;

import java.util.List;

public interface UserService {
    User login(User user);
    List<User> showAllUsers();
    User showUser(int id);

    void Update(int id,String name,double salary,int age);
    void add(String username,double salary,int age);
    void delete(int id);
}
