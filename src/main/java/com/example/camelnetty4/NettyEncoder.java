/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.camelnetty4;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.io.InputStream;

public class NettyEncoder extends MessageToByteEncoder<Object> {

	public static final int DEFAULT_BUFFER_SIZE = 1024;

	@Override
	protected void encode(ChannelHandlerContext ctx, Object message, ByteBuf out) throws Exception {
		if (message == null) {
			throw new IllegalArgumentException("Message to be encoded is null");
		} else if (message instanceof InputStream) {
			byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
			while(((InputStream)message).read(buffer) != -1) {
				out.writeBytes(buffer);
			}
		} else if (message instanceof byte[]) {
			out.writeBytes((byte[]) message);
		} else {
			throw new RuntimeException("Unrecognized message instance: " + message);
		}
		
	}
}
