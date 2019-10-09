package service;

import entity.Smuser;

public interface SmuserService {
    Smuser queryUserBynp(String name,String password);
    Smuser queryByname(String name);
}
