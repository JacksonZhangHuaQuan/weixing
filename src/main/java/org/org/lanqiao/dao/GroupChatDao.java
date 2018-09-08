package org.lanqiao.dao;

import org.lanqiao.entity.GroupChat;

import java.util.List;

public interface GroupChatDao {
    int insertMessage(GroupChat groupChat);
    List<GroupChat> selectMessage(int group_id);
}
