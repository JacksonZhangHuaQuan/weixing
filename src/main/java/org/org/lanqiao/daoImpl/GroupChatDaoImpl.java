package org.lanqiao.daoImpl;

import org.lanqiao.dao.GroupChatDao;
import org.lanqiao.entity.GroupChat;

import java.util.List;

public class GroupChatDaoImpl extends BaseDaoImpl<GroupChat> implements GroupChatDao {
    @Override
    public int insertMessage(GroupChat groupChat) {
        String sql = "insert into groupchat(group_id, user_id, message) values(?,?,?)";
        return executeUpdate(sql, new Object[]{groupChat.getGroup_id(), groupChat.getUser_id(), groupChat.getMessage()});
    }

    @Override
    public List<GroupChat> selectMessage(int group_id) {
        String sql = "select * from groupchat where group_id = ?";
        return executeQuery(sql, new Object[]{group_id});
    }
}
