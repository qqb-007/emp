package service;

import entity.Admin;

public interface AdminService {
    Admin login(Admin a);
    void add(String name,String username,String password,String sex);
}
