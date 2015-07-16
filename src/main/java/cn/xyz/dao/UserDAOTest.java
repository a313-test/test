package cn.xyz.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import javax.annotation.Resource;
import cn.xyz.entity.UserDO;

public class UserDAOTest {
    @Resource 
    private UserDAO userDAO;
	@Test
	public void test() {
	
		UserDO userDO=this.userDAO.getUserByCount("admin");
		System.out.println(userDO);
				
	}

}
