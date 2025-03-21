package org.example.service;

import org.example.dao.UserCoinMappingDAO;
import org.example.model.CoinTopic;
import org.example.model.Notification;
import org.example.model.User;

import java.util.Map;

public class NotificationManagmentService {


    private  UserCoinMappingDAO userCoinMappingDAO;

    public NotificationManagmentService(UserCoinMappingDAO userCoinMappingDAO) {
        this.userCoinMappingDAO = userCoinMappingDAO;
    }

    public void handleNotifications(Notification notification) {

        CoinTopic topic = notification.getCoinTopic();
        Map<Integer, User> subscribedUsers = userCoinMappingDAO.getAllUsers(topic);


        for (Map.Entry<Integer, User> entry : subscribedUsers.entrySet()) {

            User user = entry.getValue();
            user.consumeNotification(notification);

        }

    }
}
