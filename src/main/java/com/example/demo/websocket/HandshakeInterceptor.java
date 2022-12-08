package com.example.demo.websocket;



import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HandshakeInterceptor extends HttpSessionHandshakeInterceptor {
    /**
     * Antes del  websocket handshake
     * Por si queremos añadir algo de datos a los atributos
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        log.info("HandshakeInterceptor: beforeHandshake");
        log.info("Attributes: " + attributes.toString());
        
        log.info("wsHandler: "+wsHandler.toString());
        
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

    /**
     * Despues del websocket handshake
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception ex) {
        log.info("HandshakeInterceptor: afterHandshake");
        super.afterHandshake(request, response, wsHandler, ex);
    }
}