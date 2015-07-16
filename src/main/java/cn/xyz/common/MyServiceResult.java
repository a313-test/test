package cn.xyz.common;

import java.io.Serializable;

import cn.xyz.common.enums.ErrorEnum;
/**
 * 这是一个定义service层返回值类型的工具类
 * isSuccess为true，表示执行成功，成功的数据在model中，此时errorEnum没有意义
 * isSuccess为false，表示执行失败，失败的数据的errorEnum中，此时model没有意义
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
