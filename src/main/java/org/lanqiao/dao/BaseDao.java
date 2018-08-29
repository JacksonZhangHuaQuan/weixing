package org.lanqiao.dao;

import java.util.List;

public interface BaseDao<T> {

    //DML  不确定:类型、数量
    int executeUpdate(String sql, Object[] obj);

    //根据条件进行查询
    List<T> excuteQuery(String sql, Object[] obj);

    //查询所有
    List<T> executeQuery(String sql);

    //返回所有数据的数量
    int executeQueryCount(String sql);
}
