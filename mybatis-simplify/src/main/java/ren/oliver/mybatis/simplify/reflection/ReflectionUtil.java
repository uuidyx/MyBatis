package ren.oliver.mybatis.simplify.reflection;

import java.lang.reflect.Field;


public class ReflectionUtil {
	
	public static void setPropToBean(Object bean,String propName,Object value){
		Field f;
		try {
			f = bean.getClass().getDeclaredField(propName);
	        f.setAccessible(true);
	        f.set(bean, value);
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}
