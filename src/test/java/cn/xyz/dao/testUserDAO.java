package cn.xyz.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xyz.common.QueryUserCondition;
import cn.xyz.common.RoleEnum;
import cn.xyz.dao.UserDAO;
import cn.xyz.entity.UserDO;

public class testUserDAO {

	private UserDAO userDAO;
	@Before
	public void setUp() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext(
				new String[] {"classpath:conf/spring.xml"	});
		userDAO=(UserDAO)context.getBean("userDAO");
	}

	@Test
	public void test() {
QueryUserCondition queryUserCondition=new QueryUserCondition();
//queryUserCondition.setAccount("admin");
		System.out.println(this.userDAO.query(queryUserCondition));
	}

}
