package cn.xyz.service.impl;

import java.util.List;

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
	  if(this.userDAO.getUserByAccount(userDO.getAccount())!=null)
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

public MyServiceResult<Boolean> deleteUserByAccount(String account) {
	// TODO Auto-generated method stub
	if(StringUtils.isBlank(account))
		return MyServiceResult.failedResult(ErrorEnum.PARAM_NULL);
	  //判断要delete的账户是否已经存在
	  if(this.userDAO.getUserByAccount(account)==null)
		  return MyServiceResult.failedResult(ErrorEnum.USER_NOE_EXISES);
	  if(!this.userDAO.deleteUserByAccount(account))
		  return MyServiceResult.failedResult(ErrorEnum.DO_SQL_FAILED);
	  return MyServiceResult.successResult(Boolean.TRUE);
}

public MyServiceResult<UserDO> getUserByAccount(String account) {
	// TODO Auto-generated method stub
	if(StringUtils.isBlank(account))
		return MyServiceResult.failedResult(ErrorEnum.PARAM_NULL);
	  //判断要get的账户是否已经存在
	UserDO result=this.userDAO.getUserByAccount(account);
	  if(result==null)
		  return MyServiceResult.failedResult(ErrorEnum.USER_NOE_EXISES);
	  return MyServiceResult.successResult(result);
	  
}

public MyServiceResult<Pagination<UserDO>> query(
		QueryUserCondition queryUserCondition) {
	if(queryUserCondition==null)
		return MyServiceResult.failedResult(ErrorEnum.PARAM_NULL);
	int totalCount=this.userDAO.countQuery(queryUserCondition);
	List<UserDO> userDOList= this.userDAO.query(queryUserCondition);
	
	Pagination<UserDO> pagination=new Pagination<UserDO>(queryUserCondition.getOffset(),
			queryUserCondition.getLimit(),totalCount,userDOList);
	return MyServiceResult.successResult(pagination);
}

public MyServiceResult<Boolean> updateUser(UserDO userDO) {
	// TODO Auto-generated method stub
	  if(userDO==null)
		  return MyServiceResult.failedResult(ErrorEnum.PARAM_NULL);
	  //判断内容是否已经填写
	  if(StringUtils.isBlank(userDO.getAccount()))
			  return MyServiceResult.failedResult(ErrorEnum.USER_ACCOUNT_NULL);
	  //判断要update的账户是否已经存在
	  if(this.userDAO.getUserByAccount(userDO.getAccount())==null)
		  return MyServiceResult.failedResult(ErrorEnum.USER_NOE_EXISES);
	  if(!this.userDAO.updateUser(userDO))
		  return MyServiceResult.failedResult(ErrorEnum.DO_SQL_FAILED);
	  return MyServiceResult.successResult(Boolean.TRUE);
}
public MyServiceResult<UserDO> verifyAndGetUser(String account,String password,RoleEnum roleEnum){
	if(StringUtils.isBlank(account))
		return MyServiceResult.failedResult(ErrorEnum.USER_ACCOUNT_NULL);
	if(StringUtils.isBlank(password))
		return MyServiceResult.failedResult(ErrorEnum.USER_PASSWORD_NULL);
	if(roleEnum==null)
		return MyServiceResult.failedResult(ErrorEnum.USER_ROLE_NULL);
	if(!RoleEnum.isValid(roleEnum))
		return MyServiceResult.failedResult(ErrorEnum.USER_ROLE_NOTVALID);
	UserDO userDO=this.userDAO.getUserByAccount(account);
	if(userDO==null)
		  return MyServiceResult.failedResult(ErrorEnum.USER_NOE_EXISES);
	if(!userDO.getPassword().equals(password))
		return MyServiceResult.failedResult(ErrorEnum.USER_VALID_FAILED);
	if(userDO.getRole()!=roleEnum.getStatus())
		return MyServiceResult.failedResult(ErrorEnum.USER_VALID_FAILED);
	return MyServiceResult.successResult(userDO);
}
}
