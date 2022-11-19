package com.roopy.delivery.consumer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer  {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/delivery")
                .setAllowedOrigins("http://localhost:3000/")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // enableSimpleBroker 종류에는 topic, queue 있다.
        // topic: 한명이 message 를 발행했을 때 해당 토픽을 구독하고 있는 n명에게 메세지를 전달하는 경우
        // queue: 한명이 message 를 발행했을 때 발핸한 한 명에게 다시 정보를 보내는 경우
        registry.enableSimpleBroker("/topic");
        registry.setApplicationDestinationPrefixes("/");
    }
}
