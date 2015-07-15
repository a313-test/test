package cn.xyz.common;


/**
 * @author xuyizhen
 *
 */
public class QueryUserCondition {
   private String account;
   private String username;
   private RoleEnum role;
   private int offset=0;
   private int limit=10;
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public RoleEnum getRole() {
	return role;
}
public void setRole(RoleEnum role) {
	this.role = role;
}
public int getOffset() {
	return offset;
}
public void setOffset(int offset) {
	if(offset>0)
		this.offset = offset;
}
public int getLimit() {
	return limit;
}
public void setLimit(int limit) {
	if(limit>0)
		this.limit = limit;
}
   
}