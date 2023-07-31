package com.example.social_network;

import com.example.social_network.model.friend.Friend;
import com.example.social_network.model.user.User;
import com.example.social_network.repository.FriendRepository;
import com.example.social_network.service.data.FriendDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * @author Дмитрий Карпушов 01.08.2023
 */
public class FriendDataServiceTest {

    @Mock
    private FriendRepository friendRepository;

    @InjectMocks
    private FriendDataService friendDataService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() {
        var user = User.builder()
                .id(1)
                .email("Dima@Gmail.com")
                .login("Dima")
                .password("123456789")
                .build();
        var friendUser =User.builder()
                .id(1)
                .email("Roma@Gmail.com")
                .login("Roma")
                .password("123456789")
                .build();
        var friend = Friend.builder().user(user).friend(friendUser).build();

        friendDataService.save(friend);

        verify(friendRepository, times(1)).save(friend);
    }

    @Test
    public void testDelete() {
        var user = User.builder()
                .id(1)
                .email("Dima@Gmail.com")
                .login("Dima")
                .password("123456789")
                .build();
        var friendUser =User.builder()
                .id(1)
                .email("Roma@Gmail.com")
                .login("Roma")
                .password("123456789")
                .build();

        doNothing().when(friendRepository).deleteByUserAndFriend(user, friendUser);

        friendDataService.delete(user, friendUser);

        verify(friendRepository, times(1)).deleteByUserAndFriend(user, friendUser);
    }
}