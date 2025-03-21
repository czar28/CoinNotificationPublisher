package org.example.model;

public class UserCoinMapping {

    private User user;
    private CoinTopic coinTopic;

    public UserCoinMapping(User user, CoinTopic coinTopic) {
        this.user = user;
        this.coinTopic = coinTopic;
    }

    public User getUser() {
        return user;
    }

    public CoinTopic getCoinTopic() {
        return coinTopic;
    }
}
