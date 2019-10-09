package service;

import entity.Smuserword;

import java.util.List;

public interface SmuserwordService {
    List<Smuserword> queryAll();
    void add(Smuserword s);
    void update(int id,int up,int down);
}
