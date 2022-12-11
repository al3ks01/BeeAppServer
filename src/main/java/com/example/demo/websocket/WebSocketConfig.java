package com.example.demo.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
//@EnableWebSocket
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//public class WebSocketConfig implements  WebSocketConfigurer {
	

	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {

		//registry.addEndpoint("/beeapp").setAllowedOriginPatterns("*").withSockJS();
		registry.addEndpoint("/beeapp").addInterceptors(new HandshakeInterceptor()).withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		
		registry.enableSimpleBroker("/e","/user");
		registry.setUserDestinationPrefix("/user");
	}

	/*@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(getChatWebSocketHandler(), CHAT_ENDPONIT).setAllowedOrigins("*");
		
	}
	
	@Bean
	public WebSocketHandler getChatWebSocketHandler() {
		return new ChatWebSocketHandler();
	}*/

	/*@Override
	public boolean configureMessageConverters(List<MessageConverter> messageConverters) {

		DefaultContentTypeResolver resolver = new DefaultContentTypeResolver();
		resolver.setDefaultMimeType(MimeTypeUtils.APPLICATION_JSON);
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setObjectMapper(new ObjectMapper());
		converter.setContentTypeResolver(resolver);
		messageConverters.add(converter);

		return false;
	}*/
	

}
