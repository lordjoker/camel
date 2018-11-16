package com.example.camelnetty4;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class Route1 extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("netty4:tcp://0.0.0.0:8001?encoder=#tcpEncoder&decoder=#tcpDecoder&allowDefaultCodec=false&disconnect=true")
      .transform(constant("OK"))
      .convertBodyTo(InputStream.class);

  }
}
