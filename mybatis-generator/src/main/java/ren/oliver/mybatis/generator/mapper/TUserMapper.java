package ren.oliver.mybatis.generator.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import ren.oliver.mybatis.generator.entity.TUser;

public interface TUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    @Delete({
        "delete from t_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    @Insert({
        "insert into t_user (id, user_name, ",
        "real_name, sex, mobile, ",
        "email, note, position_id)",
        "values (#{id,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR}, ",
        "#{realName,jdbcType=VARCHAR}, #{sex,jdbcType=TINYINT}, #{mobile,jdbcType=VARCHAR}, ",
        "#{email,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR}, #{positionId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(TUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    @InsertProvider(type=TUserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insertSelective(TUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "id, user_name, real_name, sex, mobile, email, note, position_id",
        "from t_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.TINYINT),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="position_id", property="positionId", jdbcType=JdbcType.INTEGER)
    })
    TUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    @UpdateProvider(type=TUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user
     *
     * @mbggenerated
     */
    @Update({
        "update t_user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=TINYINT},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR},",
          "position_id = #{positionId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TUser record);
}