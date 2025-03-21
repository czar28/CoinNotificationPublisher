package org.example.model;

import org.example.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int id;
    private String name;
    List<CoinTopic> coinTopicList;
    //Adding a new InterfaceService ex NotifnBroadCastingService
    //Muliple implementations ex SMS, PN, email
    //NotifnBroadCastingService notifnBroadCastingService

    public User(String name) {

        this.id = Utils.getUserId();
        this.name = name;
        this.coinTopicList = new ArrayList<>();
    }

    public void subscribeToCoin(CoinTopic coinTopic) {

        if(coinTopicList.contains(coinTopic)) {
            System.out.println("Already subscribed");
            return;
        }

        coinTopicList.add(coinTopic);
    }

    public void unSubscribeToCoin(CoinTopic coinTopic) {

        if(!coinTopicList.contains(coinTopic)) {
            System.out.println("Not subscribed");
            return;
        }

        coinTopicList.remove(coinTopic);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void consumeNotification(Notification notification) {

        //NotifnBroadCastingService.sendNotif()
        System.out.println("Sending the notification to user " + this.id + " " + this.name + "  " + notification.getText());
    }
}
