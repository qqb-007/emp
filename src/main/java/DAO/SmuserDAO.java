package DAO;

import entity.Smuser;

public interface SmuserDAO {
    Smuser loginBynp(String name,String password);
    Smuser queryByname(String name);
}
