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

import org.apache.camel.component.netty4.DefaultChannelHandlerFactory;

import java.nio.charset.Charset;

abstract class ConfigAwareChannelHandlerFactory extends DefaultChannelHandlerFactory {

	protected final MLLPConfig config;

	public ConfigAwareChannelHandlerFactory() {
		this(new MLLPConfig());
	}

	public ConfigAwareChannelHandlerFactory(MLLPConfig config) {
		this.config = config;
	}

	public void setCharset(Charset charset) {
		config.setCharset(charset);
	}

	public void setCharset(String charsetName) {
		config.setCharset(Charset.forName(charsetName));
	}

	public Charset getCharset() {
		return config.getCharset();
	}

	public boolean isConvertLFtoCR() {
		return config.isConvertLFtoCR();
	}

	public void setConvertLFtoCR(boolean convertLFtoCR) {
		config.setConvertLFtoCR(convertLFtoCR);
	}

	public boolean isConvertCRtoLF() {
		return config.isConvertCRtoLF();
	}

	public void setConvertCRtoLF(boolean convertCRtoLF) {
		config.setConvertCRtoLF(convertCRtoLF);
	}

	public char getStartByte() {
		return config.getStartByte();
	}

	public void setStartByte(int startByte) {
		config.setStartByte((char) startByte);
	}

	public char getEndByte1() {
		return config.getEndByte1();
	}

	public void setEndByte1(int endByte1) {
		config.setEndByte1((char) endByte1);
	}

	public char getEndByte2() {
		return config.getEndByte2();
	}

	public void setEndByte2(int endByte2) {
		config.setEndByte2((char) endByte2);
	}

	public boolean isProduceString() {
		return config.isProduceString();
	}

	public void setProduceString(boolean apply) {
		config.setProduceString(apply);
	}
}
