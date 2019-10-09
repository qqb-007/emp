package service;

import DAO.SmuserDAO;
import entity.Smuser;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

public class SmuserServiceImpl implements SmuserService{
    @Override
    public Smuser queryUserBynp(String name, String password) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SmuserDAO smuserDAO = sqlSession.getMapper(SmuserDAO.class);
        Smuser smuser = smuserDAO.loginBynp(name,password);
        MyBatisUtil.close();
        return smuser;
    }

    @Override
    public Smuser queryByname(String name) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SmuserDAO smuserDAO = sqlSession.getMapper(SmuserDAO.class);
        Smuser smuser = smuserDAO.queryByname(name);
        MyBatisUtil.close();
        return smuser;
    }
}
