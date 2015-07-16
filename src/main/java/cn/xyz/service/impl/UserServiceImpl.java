package cn.xyz.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import cn.xyz.dao.UserDAO;
import cn.xyz.entity.UserDO;
import cn.xyz.service.IUserService;
import cn.xyz.common.*;
@Service("userService")
public class UserServiceImpl implements IUserService {
	
  @Resource
  private UserDAO userDAO;
  
 
  public MyServiceResult<Boolean> createUser(UserDO userDO){
	  if(userDO==null)
		  return MyServiceResult.failedResult(ErrorEnum.PARAM_NULL);
	  //判断内容是否已经填写
	  if(StringUtils.isBlank(userDO.getAccount()))
			  return MyServiceResult.failedResult(ErrorEnum.USER_ACCOUNT_NULL);
	  if(StringUtils.isBlank(userDO.getUsername()))
		     return MyServiceResult.failedResult(ErrorEnum.USER_USERNAME_NULL);
	  if(StringUtils.isBlank(userDO.getPassword()))
		  return MyServiceResult.failedResult(ErrorEnum.USER_PASSWORD_NULL);
	  if(userDO.getRole()==0)//代码默认role的值是0时为空
		  return MyServiceResult.failedResult(ErrorEnum.USER_ROLE_NULL);
	  //判断要添加的账户是否已经存在
	  if(this.userDAO.getUserByCount(userDO.getAccount())!=null)
		  return MyServiceResult.failedResult(ErrorEnum.USER_EXISES);
	  if(!this.userDAO.createUser(userDO))
		  return MyServiceResult.failedResult(ErrorEnum.DO_SQL_FAILED);
	 return MyServiceResult.successResult(Boolean.TRUE);
  }
  
  public MyServiceResult<Integer>  countQuery(QueryUserCondition queryUserCondition){
	  if(queryUserCondition==null)
		  return MyServiceResult.failedResult(ErrorEnum.PARAM_NULL);
	  int result=this.userDAO.countQuery(queryUserCondition);
	  return MyServiceResult.successResult(result);
  }
}
