package com.example.social_network.service.data;

import com.example.social_network.model.friend.Friend;
import com.example.social_network.model.user.User;
import com.example.social_network.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Дмитрий Карпушов 30.07.2023
 */
@Service
@RequiredArgsConstructor
public class FriendDataService {

    private final FriendRepository friendRepository;

    @Transactional(propagation = Propagation.MANDATORY)
    public void save(Friend friend){
        friendRepository.save(friend);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void delete(User user, User friend){
        friendRepository.deleteByUserAndFriend(user, friend);
    }

}
