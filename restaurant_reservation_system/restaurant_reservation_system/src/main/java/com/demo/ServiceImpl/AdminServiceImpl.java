package com.demo.ServiceImpl;

import com.demo.Service.AdminService;
import com.demo.dao.AdminDao;
import com.demo.daoImpl.AdminDaoImpl;
import com.demo.entity.Admin;

public class AdminServiceImpl implements AdminService  
{
	AdminDao adminDao=new AdminDaoImpl();
	@Override
	public Admin createAdmin(Admin admin) {
		return adminDao.createAdmin(admin);
	}
	@Override
	public Admin getAdmin(String adminId) {
		return adminDao.getAdmin(adminId);
	}
	@Override
	public Admin loginAdmin(String username,String password) {
		return adminDao.getAdminByUsernameAndPassword( username, password);
	}
}
