package service;

import DAO.UserDAO;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public User login(User user) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        User queryUser = userDAO.queryUser(user);
        MyBatisUtil.close();
        return queryUser;
    }

    @Override
    public List<User> showAllUsers() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        List<User> queryAllUser = userDAO.queryAllUser();
        MyBatisUtil.close();
        return queryAllUser;
    }

    @Override
    public User showUser(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        User queryUser = userDAO.queryUserByID(id);
        MyBatisUtil.close();
        return queryUser;
    }

    @Override
    public void Update(int id, String name, double salary, int age) {

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        userDAO.upDate(id, name, salary, age);
        MyBatisUtil.commit();
    }

    @Override
    public void add(String username,double salary,int age) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        User user = new User(0,username,"123123",salary,age);
        //System.out.println(user);
        userDAO.add(user);
        MyBatisUtil.commit();
    }

    @Override
    public void delete(int id) {

        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        userDAO.delete(id);
        MyBatisUtil.commit();
    }

}
