package DAO;

import entity.Admin;

public interface AdminDAO {
    Admin selectAdmin(Admin a);
    void add(Admin a);
}
