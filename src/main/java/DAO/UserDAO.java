package DAO;

import entity.User;

import java.util.List;

public interface UserDAO {//查询一个用户
    User queryUser(User user);
    //查询所有用户
    List<User> queryAllUser();
    //通过ID查询用户
    User queryUserByID(int id);
    //修改用户信息
    void upDate(int id,String name,double salary,int age);
    //添加用户
    void add(User user);
    //删除用户
    void delete(int id);
}
