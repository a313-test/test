package cn.xyz.dao;
import javax.annotation.Resource;


import org.junit.Test;

import cn.xyz.common.RoleEnum;
import cn.xyz.entity.UserDO;

public class UserDAOTest {
  @Resource
   private UserDAO userDAO;
	@Test
	public void test() {
		UserDO userDO=new UserDO();
		userDO.setAccount("test");
		userDO.setPassword("111");
		userDO.setRole(RoleEnum.BOSS.getStatus());
		userDO.setUsername("test");
		System.out.println(this.userDAO);
	//	userDO=this.userDAO.getUserByCount("account");
	//	System.out.println(userDO.getAccount());
	}

}
