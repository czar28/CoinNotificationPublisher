package org.example;

import org.example.dao.UserCoinMappingDAO;
import org.example.dao.UserDAO;
import org.example.dao.impl.UserCoinMappingDAOImpl;
import org.example.dao.impl.UserDAOImpl;
import org.example.model.CoinTopic;
import org.example.model.Notification;
import org.example.model.User;
import org.example.model.UserCoinMapping;
import org.example.service.NotificationManagmentService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



        UserDAO userDAO = new UserDAOImpl();
        UserCoinMappingDAO userCoinMappingDAO = new UserCoinMappingDAOImpl();
        NotificationManagmentService notificationManagmentService = new NotificationManagmentService(userCoinMappingDAO);

        User user = new User("Abhsihek");
        userDAO.saveUser(user);

        User savedUser = userDAO.getUserById(1);
        System.out.println("My user is " + savedUser.getId());




        CoinTopic bitcoinTopic = new CoinTopic("Bitcoin");
        CoinTopic ethereumTopic = new CoinTopic("Ethereum");
        CoinTopic polkaDotTopic = new CoinTopic("Polkadot");


        user.subscribeToCoin(bitcoinTopic);
        UserCoinMapping userCoinMapping = new UserCoinMapping(user, bitcoinTopic);
        userCoinMappingDAO.addUserCoinMapping(userCoinMapping);

        userDAO.saveUser(user);


        Notification notification = new Notification(bitcoinTopic, "Prices up by 10%");

        notificationManagmentService.handleNotifications(notification);

//        user.unSubscribeToCoin(bitcoinTopic);
//        userCoinMappingDAO.removeUserCoinMapping(userCoinMapping);


        User userA = new User("A user");
        userDAO.saveUser(user);

        User userB = new User("B user");
        userDAO.saveUser(user);

        User userC = new User("C user");
        userDAO.saveUser(user);


        UserCoinMapping userCoinMappingABitCoin = new UserCoinMapping(userA, bitcoinTopic);
        userCoinMappingDAO.addUserCoinMapping(userCoinMappingABitCoin);

        UserCoinMapping userCoinMappingAEthCoin = new UserCoinMapping(userA, ethereumTopic);
        userCoinMappingDAO.addUserCoinMapping(userCoinMappingAEthCoin);


        Notification notificationLatest = new Notification(bitcoinTopic, "Prices up by 20%");

        Notification notification3 = new Notification(ethereumTopic, "Prices up by 290%");

        notificationManagmentService.handleNotifications(notificationLatest);
        notificationManagmentService.handleNotifications(notification3);

//        user.unSubscribeToCoin(bitcoinTopic);
        userCoinMappingDAO.removeUserCoinMapping(userCoinMapping);
        userCoinMappingDAO.removeUserCoinMapping(userCoinMappingABitCoin);
        userCoinMappingDAO.removeUserCoinMapping(userCoinMappingAEthCoin);

        System.out.println("Unsubscribing Users from their Topics--------------");

        notificationManagmentService.handleNotifications(notificationLatest);
        notificationManagmentService.handleNotifications(notification3);


    }
}