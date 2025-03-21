package org.example.model;

public class Notification {

    private CoinTopic coinTopic;
    private String text;

    public Notification(CoinTopic coinTopic, String text) {
        this.coinTopic = coinTopic;
        this.text = text;
    }

    public CoinTopic getCoinTopic() {
        return coinTopic;
    }

    public String getText() {
        return text;
    }
}
