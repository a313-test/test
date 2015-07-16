package cn.xyz.common;

import java.io.Serializable;
/**
 * 这是一个定义service层返回值类型的工具类
 * 如果能够执行目标sql，无论sql成功或执行失败，都使用successResult
 * 如果不能够目标sql，使用failedResult
 * @author xuyizhen
 *
 * @param <T>
 */
public class MyServiceResult <T> implements Serializable{

	private static final long serialVersionUID = 1L;
	protected boolean isSuccess;
	protected T model;
	protected ErrorEnum errorEnum;
	
	public MyServiceResult() {
		super();
	}

	
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public T getModel() {
		return model;
	}
	public void setModel(T model) {
		this.model = model;
	}

	
	public ErrorEnum getErrorEnum() {
		return errorEnum;
	}


	public void setErrorEnum(ErrorEnum errorEnum) {
		this.errorEnum = errorEnum;
	}


	public static <T> MyServiceResult<T> successResult(T model){
		MyServiceResult<T> result = new MyServiceResult<T>();
		result.setModel(model);
		result.setSuccess(true);
		return result;
	}
	
	public static <T> MyServiceResult<T> failedResult(ErrorEnum errorEnum){
		MyServiceResult<T> result = new MyServiceResult<T>();
		result.setSuccess(false);
		if(errorEnum==null)
			result.setErrorEnum(ErrorEnum.PARAM_UNKONWN);
		else
			result.setErrorEnum(errorEnum);
		return result;
	}
}
