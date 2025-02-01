package com.example.fcm.service.impl;

import com.example.fcm.service.FcmSendService;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class TopicMessageSender implements FcmSendService {

    @Override
    public void send() throws FirebaseMessagingException {
        // The topic name can be optionally prefixed with "/topics/".
        String topic = "highScores";

        // See documentation on defining a message payload.
        Message message = Message.builder()
                .putData("score", "850")
                .putData("time", "2:45")
                .setTopic(topic)
                .build();

        // Send a message to the devices subscribed to the provided topic.
        String response = FirebaseMessaging.getInstance().send(message);

        // Response is a message ID string.
        System.out.println("Successfully sent message: " + response);
    }
}
