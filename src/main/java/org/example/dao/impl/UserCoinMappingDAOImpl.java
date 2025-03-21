package org.example.dao.impl;

import org.example.dao.UserCoinMappingDAO;
import org.example.model.CoinTopic;
import org.example.model.User;
import org.example.model.UserCoinMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserCoinMappingDAOImpl implements UserCoinMappingDAO {

    Map<CoinTopic, Map<Integer, User>> topicUserMap;

    public UserCoinMappingDAOImpl() {
        this.topicUserMap = new HashMap<>();
    }

    @Override
    public void addUserCoinMapping(UserCoinMapping userCoinMapping) {
        if(!topicUserMap.containsKey(userCoinMapping.getCoinTopic())) {
            topicUserMap.put(userCoinMapping.getCoinTopic(), new HashMap<>());
        }
        topicUserMap.get(userCoinMapping.getCoinTopic()).put(userCoinMapping.getUser().getId(), userCoinMapping.getUser());
    }

    @Override
    public void removeUserCoinMapping(UserCoinMapping userCoinMapping) {

        if(!topicUserMap.containsKey(userCoinMapping.getCoinTopic())) {
            System.out.println("Not present in subscription");
        }
        topicUserMap.get(userCoinMapping.getCoinTopic()).remove(userCoinMapping.getUser().getId());


    }

    @Override
    public Map<Integer, User> getAllUsers(CoinTopic coinTopic) {
        return topicUserMap.get(coinTopic);
    }
}
