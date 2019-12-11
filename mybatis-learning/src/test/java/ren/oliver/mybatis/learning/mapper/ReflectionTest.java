package ren.oliver.mybatis.learning.mapper;

import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.Reflector;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.reflection.wrapper.BeanWrapper;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.junit.Test;
import ren.oliver.mybatis.learning.pojo.Position;
import ren.oliver.mybatis.learning.pojo.User;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReflectionTest {

    @Test
    public void reflectionTest1 () {
        // 反射工具类初始化
        ObjectFactory objectFactory = new DefaultObjectFactory();
        User user = objectFactory.create(User.class);
        ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();
        ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
        MetaObject metaObject = MetaObject.forObject(user, objectFactory, objectWrapperFactory, reflectorFactory);

        // 使用Reflector读取类元信息
		Reflector findForClass = reflectorFactory.findForClass(User.class);
		Constructor<?> defaultConstructor = findForClass.getDefaultConstructor();
		String[] getablePropertyNames = findForClass.getGetablePropertyNames();
		String[] setablePropertyNames = findForClass.getSetablePropertyNames();
		System.out.println(defaultConstructor.getName());
		System.out.println(Arrays.toString(getablePropertyNames));
		System.out.println(Arrays.toString(setablePropertyNames));

	    // 使用ObjectWrapper读取对象信息，并对对象属性进行赋值操作
		User userTemp = new User();
		ObjectWrapper wrapperForUser = new BeanWrapper(metaObject, userTemp);
		String[] getterNames = wrapperForUser.getGetterNames();
		String[] setterNames = wrapperForUser.getSetterNames();
		System.out.println(Arrays.toString(getterNames));
		System.out.println(Arrays.toString(setterNames));
		PropertyTokenizer prop = new PropertyTokenizer("userName");
		wrapperForUser.set(prop, "lison");
		System.out.println(userTemp);
    }

    // 模拟数据库行数据转化成对象
    @Test
    public void reflectionTest2 () {
        // 反射工具类初始化
        ObjectFactory objectFactory = new DefaultObjectFactory();
        User user = objectFactory.create(User.class);
        ObjectWrapperFactory objectWrapperFactory = new DefaultObjectWrapperFactory();
        ReflectorFactory reflectorFactory = new DefaultReflectorFactory();
        MetaObject metaObject = MetaObject.forObject(user, objectFactory, objectWrapperFactory, reflectorFactory);

        // 模拟从数据库读取数据
        Map<String, Object> dbResult = new HashMap<>();
        dbResult.put("id", 1);
        dbResult.put("user_name", "lison");
        dbResult.put("real_name", "李晓宇");
        Position tp = new Position();
        tp.setId(1);
        dbResult.put("position_id", tp);

        // 模拟映射关系
        Map<String, String> mapper = new HashMap<String, String>();
        mapper.put("id", "id");
        mapper.put("userName", "user_name");
        mapper.put("realName", "real_name");
        mapper.put("position", "position_id");

        // 使用反射工具类将行数据转换成pojo
        BeanWrapper objectWrapper = (BeanWrapper) metaObject.getObjectWrapper();
        Set<Map.Entry<String, String>> entrySet = mapper.entrySet();
        for (Map.Entry<String, String> colInfo : entrySet) {
            String propName = colInfo.getKey();
            Object propValue = dbResult.get(colInfo.getValue());
            PropertyTokenizer proTokenizer = new PropertyTokenizer(propName);
            objectWrapper.set(proTokenizer, propValue);
        }
        System.out.println(metaObject.getOriginalObject());
    }

}
