package cn.xyz.service;

import cn.xyz.common.MyServiceResult;
import cn.xyz.common.Pagination;
import cn.xyz.common.QueryUserCondition;
import cn.xyz.common.enums.RoleEnum;
import cn.xyz.entity.UserDO;

public interface IUserService {
	public MyServiceResult<Boolean> createUser(UserDO userDO);
	public MyServiceResult<Integer>  countQuery(QueryUserCondition queryUserCondition);
	public MyServiceResult<Boolean> deleteUserByAccount(String account);
	public MyServiceResult<UserDO> getUserByAccount(String account);
	public MyServiceResult<Pagination<UserDO>> query(QueryUserCondition queryUserCondition);
	public MyServiceResult<Boolean> updateUser(UserDO userDO);
	public MyServiceResult<UserDO> verifyAndGetUser(String account,String password,RoleEnum roleEnum);
	
	
	 
}
