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

import java.nio.charset.Charset;

public class MLLPConfig {

	private Charset charset = Charset.defaultCharset();

	private boolean convertLFtoCR;

	private boolean convertCRtoLF;

	// HL7 MLLP start and end markers
	
	private char startByte = 0x01; // 11 decimal

	private char endByte1 = 0x0d; // 28 decimal

	private char endByte2 = 0x0a; // 13 decimal

	private boolean produceString = false;

	public Charset getCharset() {
		return charset;
	}

	public void setCharset(Charset charset) {
		this.charset = charset;
	}

	public boolean isConvertLFtoCR() {
		return convertLFtoCR;
	}

	public void setConvertLFtoCR(boolean convertLFtoCR) {
		if (convertLFtoCR && convertCRtoLF) {
			convertCRtoLF = false;
		}

		this.convertLFtoCR = convertLFtoCR;
	}

	public boolean isConvertCRtoLF() {
		return convertCRtoLF;
	}

	public void setConvertCRtoLF(boolean convertCRtoLF) {
		if (convertCRtoLF && convertLFtoCR) {
			convertLFtoCR = false;
		}

		this.convertCRtoLF = convertCRtoLF;
	}

	public char getStartByte() {
		return startByte;
	}

	public void setStartByte(char startByte) {
		this.startByte = startByte;
	}

	public char getEndByte1() {
		return endByte1;
	}

	public void setEndByte1(char endByte1) {
		this.endByte1 = endByte1;
	}

	public char getEndByte2() {
		return endByte2;
	}

	public void setEndByte2(char endByte2) {
		this.endByte2 = endByte2;
	}

	public boolean isProduceString() {
		return produceString;
	}

	public void setProduceString(boolean produceString) {
		this.produceString = produceString;
	}
}