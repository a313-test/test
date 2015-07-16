package cn.xyz.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.xyz.common.MyServiceResult;
import cn.xyz.common.Pagination;
import cn.xyz.common.QueryUserCondition;
import cn.xyz.common.enums.RoleEnum;
import cn.xyz.dao.UserDAO;
import cn.xyz.entity.UserDO;
import cn.xyz.service.IUserService;

public class testUserDAO {

	private IUserService userService;
	@Before
	public void setUp() throws Exception {
		@SuppressWarnings("resource")
		ApplicationContext context=new ClassPathXmlApplicationContext(
				new String[] {"classpath:conf/spring.xml"	});
		userService=(IUserService)context.getBean("userService");
	}

	@Test
	public void test() {
    QueryUserCondition queryUserCondition=new QueryUserCondition();
     MyServiceResult<Pagination<UserDO>> result=this.userService.query(queryUserCondition);
     
     if(!result.isSuccess())
    	 System.out.println(result.getErrorEnum());
     else
		 System.out.println(result.getModel().getList());
	}

}
