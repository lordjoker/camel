package com.example.camelnetty4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CamelNetty4Application {

    public static void main(String[] args) {
        SpringApplication.run(CamelNetty4Application.class, args);
    }

    @Bean
    NettyDecoderFactory tcpDecoder() {
        return new NettyDecoderFactory();
    }

    @Bean
    NettyEncoderFactory tcpEncoder() {
        return new NettyEncoderFactory();
    }
}
