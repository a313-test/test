package cn.xyz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.xyz.common.QueryUserCondition;
import cn.xyz.entity.UserDO;

public interface UserMapper {
	/**
	 * 插入一个用户
	 * userDO的account,username,password,role不能为空，并且account不能重复
	 * @param userDO
	 * @return
	 */
   int createUser(UserDO userDO);
   /**
    * 根据account删除用户
    * @param account
    * @return
    */
   int deleteUserByAccount(@Param("account") String account);
   /**
    * 更新用户信息，account不能为空
    * @param userDO
    * @return
    */
   int updateUser(UserDO userDO);
   /**
    * 根据account查询用户信息
    * @param account
    * @return
    */
   UserDO getUserByAccount(@Param("account") String account);
   /**
    * 根据条件返回用户数量
    * @param queryUserCondition
    * @return
    */
   int countQuery(QueryUserCondition queryUserCondition);
   /**
    * 根据条件返回用户
    * @param queryUserCondition
    * @return
    */
   List<UserDO> query(QueryUserCondition queryUserCondition);
}
