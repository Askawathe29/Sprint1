package com.demo.dao;

import com.demo.entity.Admin;

public interface AdminDao
{
	Admin createAdmin(Admin admin);
	Admin getAdmin(String adminId);
	Admin getAdminByUsernameAndPassword(String username,String password);

}
