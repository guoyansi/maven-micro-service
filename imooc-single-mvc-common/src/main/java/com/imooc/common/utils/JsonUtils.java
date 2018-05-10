package com.imooc.common.utils;

import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义响应结构, 转换类
 * @author guoyansi
 *
 */
public class JsonUtils {
	private static final ObjectMapper MAPPER=new ObjectMapper();
	
	/**
	 * 将对象转换成json字符串
	 */
	public static String objectToJson(Object data) {
		try {
			String s=MAPPER.writeValueAsString(data);
			return s;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将json结果集转化为对象
	 * @param jsonData
	 * @param beanType
	 * @return
	 */
	public static <T> T jsonToPojo(String jsonData,Class<T> beanType){
		try {
			T t=MAPPER.readValue(jsonData, beanType);
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * json数据转换成pojo对象list
	 * @param jsonData
	 * @param beanType
	 * @return
	 */
	public static <T> List<T> jsonToList(String jsonData,Class<T> beanType){
		JavaType javaType=MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
		try {
			List<T> list=MAPPER.readValue(jsonData, javaType);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
