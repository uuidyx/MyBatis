package ren.oliver.mybatis.learning.mapper;

import ren.oliver.mybatis.learning.pojo.EmailSexBean;
import ren.oliver.mybatis.learning.pojo.User;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert1(User record);

    int insert2(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectUserJobs1();

    List<User> selectUserJobs2();

    List<User> selectByEmailAndSex1(Map<String, Object> param);

    List<User> selectByEmailAndSex2(
            @Param("email") String email,
            @Param("sex") Byte sex
    );

    List<User> selectByEmailAndSex3(EmailSexBean esb);

    List<User> selectBySymbol(
            @Param("tableName") String tableName,
            @Param("inCol") String inCol,
            @Param("orderStr") String orderStr,
            @Param("sex") Byte sex
    );

    List<User> selectIfOper1(
            @Param("email") String email,
            @Param("sex") Byte sex
    );

    List<User> selectIfOper2(
            @Param("email") String email,
            @Param("sex") Byte sex
    );

    List<User> selectIfandWhereOper(
            @Param("email") String email,
            @Param("sex") Byte sex
    );

    int updateIfOper1(User record);

    int updateIfOper2(User record);

    int updateIfAndSetOper(User record);

    int insertIfOper(User record);

    List<User> selectForeach4In(String[] names);

    int insertForeach4Batch(List<User> users);

}
