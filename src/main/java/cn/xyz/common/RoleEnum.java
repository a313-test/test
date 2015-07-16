package cn.xyz.common;

public enum RoleEnum {
	BOSS(1,"老板"),
	SELL(2,"sell"),
	EMPLOYEE(3,"employee");
	
	private int status;
	private String desc;
	
	private RoleEnum(int status,String desc){
		this.status=status;
		this.desc=desc;
	}

	
	public String getDesc() {
		return desc;
	}

	public int getStatus() {
		return status;
	}
	
	public static RoleEnum getRoleEnumByStatus(int status){
		for(RoleEnum roleEnum:RoleEnum.values()){
			if(roleEnum.getStatus()==status)
				return roleEnum;
		}
		return null;
	}
	
	public static boolean isValid(RoleEnum role){
		for(RoleEnum roleEnum:RoleEnum.values()){
			if(roleEnum.getStatus()==role.status)
				return true;
		}
		return false;
	}
	
}
