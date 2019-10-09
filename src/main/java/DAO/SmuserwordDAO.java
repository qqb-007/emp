package DAO;

import entity.Smuserword;

import java.util.List;

public interface SmuserwordDAO {
    List<Smuserword> queryAll();
    void add(Smuserword s);
    void update(int id,int up,int down);
}
