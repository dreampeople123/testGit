package com.dream.muke.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dream.muke.entity.Admin;
import com.dream.muke.service.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class AdminServiceImplTest {
	@Autowired
	private AdminService adminService;

	@Test
	public void testAdminLogin() {
		Admin admin=new Admin();
		admin.setaName("a");
		admin.setaPwd("a");
		
		Admin a=adminService.adminLogin(admin);
		System.out.println(a);
		
		assertNotNull(a);
	}

}
