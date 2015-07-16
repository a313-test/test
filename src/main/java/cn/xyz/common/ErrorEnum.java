package cn.xyz.common;

public enum ErrorEnum {
	PARAM_UNKONWN(0,"未知的错误"),
	PARAM_NULL(1,"参数为空"),
	USER_ACCOUNT_NULL(2,"用户账号为空"),
	USER_USERNAME_NULL(3,"用户姓名为空"),
	USER_PASSWORD_NULL(4,"用户密码为空"),
	USER_ROLE_NULL(5,"用户角色为空"),
	DO_SQL_FAILED(6,"sql语句执行失败"),
	USER_EXISES(7,"用户已经存在");
    private int msgCode;
    private String msgInfo;
	private ErrorEnum(int msgCode, String msgInfo) {
		this.msgCode = msgCode;
		this.msgInfo = msgInfo;
	}
	public int getMsgCode() {
		return msgCode;
	}

	public String getMsgInfo() {
		return msgInfo;
	}
    
}
