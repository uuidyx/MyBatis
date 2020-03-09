package ren.oliver.mybatis.simplify;

import org.junit.Test;
import ren.oliver.mybatis.simplify.session.SqlSessionFactory;

public class SqlSessionFactoryTest {

    @Test
    public void sqlSessionFactoryTest() {
        SqlSessionFactory fa = new SqlSessionFactory();
        System.out.println(fa);
    }

}
