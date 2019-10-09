package service;

import DAO.AdminDAO;
import entity.Admin;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

public class AdminServiceImpl implements AdminService{
    @Override
    public Admin login(Admin a) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
        Admin admin = adminDAO.selectAdmin(a);
        MyBatisUtil.close();
        return admin;

    }

    @Override
    public void add(String name, String username, String password, String sex) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        AdminDAO adminDAO = sqlSession.getMapper(AdminDAO.class);
        Admin admin = new Admin(0,name,username,password,sex);
        //System.out.println(user);
        adminDAO.add(admin);
        MyBatisUtil.commit();
    }
}
