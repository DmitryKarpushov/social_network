package com.example.social_network.repository;

import com.example.social_network.model.friend.Friend;
import com.example.social_network.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Дмитрий Карпушов 30.07.2023
 */
@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer> {

    @Modifying
    @Transactional
    void deleteByUserAndFriend(User user, User friend);
}
