package org.example.dao;

import org.example.model.CoinTopic;
import org.example.model.User;
import org.example.model.UserCoinMapping;

import java.util.List;
import java.util.Map;

public interface UserCoinMappingDAO {

    public void addUserCoinMapping(UserCoinMapping userCoinMapping);
    public void removeUserCoinMapping(UserCoinMapping userCoinMapping);
    public Map<Integer, User> getAllUsers(CoinTopic coinTopic);
}
