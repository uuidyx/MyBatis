package ren.oliver.mybatis.spring.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import ren.oliver.mybatis.spring.entity.TUserRole;

public interface TUserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(@Param("roleId") Integer roleId, @Param("userId") Integer userId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    int insert(TUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_role
     *
     * @mbggenerated
     */
    List<TUserRole> selectAll();
}