package service;

import DAO.SmuserwordDAO;
import entity.Smuserword;
import org.apache.ibatis.session.SqlSession;
import util.MyBatisUtil;

import java.util.List;

public class SmuserwordImpl implements SmuserwordService {
    @Override
    public List<Smuserword> queryAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SmuserwordDAO sDAO = sqlSession.getMapper(SmuserwordDAO.class);
        List<Smuserword> smuserwords = sDAO.queryAll();
        MyBatisUtil.close();
        return smuserwords;
    }

    @Override
    public void add(Smuserword s) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SmuserwordDAO sDAO = sqlSession.getMapper(SmuserwordDAO.class);
        //Smuserword smuserword = new Smuserword(0,"666",10,10,1,"李白");
        sDAO.add(s);
        MyBatisUtil.commit();
    }

    @Override
    public void update(int id, int up, int down) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SmuserwordDAO sDAO = sqlSession.getMapper(SmuserwordDAO.class);
        /*Smuserword smuserword = new Smuserword(0,"666",10,10,1,"李白");
        sDAO.add(smuserword);
        MyBatisUtil.commit();*/
        sDAO.update(id,up,down);
        MyBatisUtil.commit();
    }
}
