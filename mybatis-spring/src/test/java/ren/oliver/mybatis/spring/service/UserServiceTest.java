package ren.oliver.mybatis.spring.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ren.oliver.mybatis.spring.entity.TUser;

public class UserServiceTest {

    @Test
    public void getUserByIdTest() {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = app.getBean(UserService.class);
        TUser user = userService.getUserById(1);
        System.out.println(user.toString());
    }

}
