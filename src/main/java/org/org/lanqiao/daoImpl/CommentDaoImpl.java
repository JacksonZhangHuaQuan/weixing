package org.lanqiao.daoImpl;

import org.lanqiao.dao.CommentDao;
import org.lanqiao.entity.Comment;

import java.util.List;

public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao{
    @Override
    public int insertComment(Comment comment) {
        return executeUpdate("insert into comment(comment_num,comment_content,strategy_id,user_id,user_name) values(?,?,?,?,?)",new Object[]{comment.comment_num,comment.comment_content,comment.strategy_id,comment.user_id,comment.user_name});
    }

    @Override
    public int delectComment(String comment_id) {
        return 0;
    }

    @Override
    public List<Comment> selectComment(int strategy_id) {
        String sql = "select * from comment where strategy_id = ? order by comment_date desc";
        return executeQuery(sql , new Object[]{strategy_id});
    }
}
