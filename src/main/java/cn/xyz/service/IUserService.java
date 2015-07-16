package cn.xyz.service;

import cn.xyz.common.MyServiceResult;
import cn.xyz.common.QueryUserCondition;
import cn.xyz.entity.UserDO;

public interface IUserService {
	public MyServiceResult<Boolean> createUser(UserDO userDO);
	public MyServiceResult<Integer>  countQuery(QueryUserCondition queryUserCondition);
	 
}
