package org.lanqiao.dao;

import org.lanqiao.entity.Comment;

public interface CommentDao {

    //插入评论
    int insertComment(Comment comment);

    //删除评论
    int delectComment(String comment_id);

}
