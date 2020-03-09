package ren.oliver.mybatis.simplify;

import org.junit.Test;
import ren.oliver.mybatis.simplify.entity.User;
import ren.oliver.mybatis.simplify.reflection.ReflectionUtil;

import java.lang.reflect.Field;

public class ReflectionUtilTest {

    @Test
    public void reflectionUtilTest() {
        User user = new User();
        ReflectionUtil.setPropToBean(user, "userName", "lison");
        System.out.println(user);
        Field[] declaredFields = user.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName());
            System.out.println(field.getType().getSimpleName());
        }
    }

}
