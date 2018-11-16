package com.example.camelnetty4;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.netty4.NettyConstants;
import org.apache.camel.processor.aggregate.GroupedExchangeAggregationStrategy;
import org.springframework.stereotype.Component;

import java.io.InputStream;

@Component
public class Route2 extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    from("netty4:tcp://0.0.0.0:8002?encoder=#tcpEncoder&decoder=#tcpDecoder&allowDefaultCodec=false&disconnect=true")
      
      .aggregate(header(NettyConstants.NETTY_REMOTE_ADDRESS), new GroupedExchangeAggregationStrategy())
      .completionTimeout(1000)      
      .transform(constant("OK"))
      .convertBodyTo(InputStream.class);

  }
}
