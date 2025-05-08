package com.demo.Service;

import com.demo.entity.Admin;

public interface AdminService
{
	Admin createAdmin(Admin admin);	
	Admin getAdmin(String adminID);
	Admin loginAdmin(String username,String password);

}
