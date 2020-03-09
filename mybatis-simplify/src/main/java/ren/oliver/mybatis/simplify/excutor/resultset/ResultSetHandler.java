package ren.oliver.mybatis.simplify.excutor.resultset;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ResultSetHandler {

  <E> List<E> handleResultSets(ResultSet resultSet) throws SQLException;

}
