package cn.xyz.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.xyz.common.QueryUserCondition;
import cn.xyz.dao.UserDAO;
import cn.xyz.entity.UserDO;
import cn.xyz.mapper.UserMapper;

@Service("userDAO")
public class UserDAO {
	 
	@Resource
	  private UserMapper userMapper;
	/**
	 * 
	 * @param userDO
	 * @return
	 */
	  public boolean createUser(UserDO userDO){
		  if(userDO==null)
			  return false;
		  return this.userMapper.createUser(userDO)==1;
	  }
	  /**
	   * 
	   * @param account
	   * @return
	   */
	  public boolean deleteUserByAccount(String account){
		  if(account ==null)
			  return false;
		  return this.userMapper.deleteUserByAccount(account)==1;
	  }
	  /**
	   * 
	   * @param userDO
	   * @return
	   */
	  public boolean updateUser(UserDO userDO){
		  if(userDO==null)
			  return false;
		  return this.userMapper.updateUser(userDO)==1;
	  }
	  /**
	   * 
	   * @param queryUserCondition
	   * @return
	   */
	  public int countQuery(QueryUserCondition queryUserCondition){
		  if(queryUserCondition ==null)
			  return 0;
		  return this.userMapper.countQuery(queryUserCondition);
	  }
	  /**
	   * 
	   * @param queryUserCondition
	   * @return
	   */
	  public List<UserDO> query(QueryUserCondition queryUserCondition){
		  if(queryUserCondition==null)
			  return new ArrayList<UserDO>();
		  return this.userMapper.query(queryUserCondition);
	  }
	  public UserDO getUserByCount(String account){
		  if(account==null)
			  return null;
		  return this.userMapper.getUserByAccount(account);
	  }
}
