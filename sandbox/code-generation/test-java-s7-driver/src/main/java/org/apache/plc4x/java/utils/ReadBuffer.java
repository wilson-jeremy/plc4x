/*
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */

package org.apache.plc4x.java.utils;

import org.apache.commons.compress.utils.BitInputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteOrder;

public class ReadBuffer {

    private BitInputStream bis;

    
    public ReadBuffer(byte[] input) {
        ByteArrayInputStream bais = new ByteArrayInputStream(input);
        bis = new BitInputStream(bais, ByteOrder.BIG_ENDIAN);
    }

    public int getPos() {
        return (int) bis.getBytesRead();
    }

    public boolean readBit() throws ParseException {
        try {
            return bis.readBits(1) == 1;
        } catch (IOException e) {
            throw new ParseException("Error reading", e);
        }
    }

    public byte readUnsignedByte(int bitLength) throws ParseException {
        if(bitLength <= 0) {
            throw new ParseException("unsigned byte must contain at least 1 bit");
        }
        if(bitLength > 4) {
            throw new ParseException("unsigned byte can only contain max 4 bits");
        }
        try {
            return (byte) bis.readBits(bitLength);
        } catch (IOException e) {
            throw new ParseException("Error reading", e);
        }
    }

    public short readUnsignedShort(int bitLength) throws ParseException {
        if(bitLength <= 0) {
            throw new ParseException("unsigned short must contain at least 1 bit");
        }
        if(bitLength > 8) {
            throw new ParseException("unsigned short can only contain max 8 bits");
        }
        try {
            return (short) bis.readBits(bitLength);
        } catch (IOException e) {
            throw new ParseException("Error reading", e);
        }
    }

    public int readUnsignedInt(int bitLength) throws ParseException {
        if(bitLength <= 0) {
            throw new ParseException("unsigned int must contain at least 1 bit");
        }
        if(bitLength > 16) {
            throw new ParseException("unsigned int can only contain max 16 bits");
        }
        try {
            return (int) bis.readBits(bitLength);
        } catch (IOException e) {
            throw new ParseException("Error reading", e);
        }
    }

    public long readUnsignedLong(int bitLength) throws ParseException {
        if(bitLength <= 0) {
            throw new ParseException("unsigned long must contain at least 1 bit");
        }
        if(bitLength > 32) {
            throw new ParseException("unsigned long can only contain max 32 bits");
        }
        try {
            return bis.readBits(bitLength);
        } catch (IOException e) {
            throw new ParseException("Error reading", e);
        }
    }

    public BigInteger readUnsignedBigInteger(int bitLength) throws ParseException {
        throw new UnsupportedOperationException("not implemented yet");
    }

    public byte readByte(int bitLength) throws ParseException {
        if(bitLength <= 0) {
            throw new ParseException("byte must contain at least 1 bit");
        }
        if(bitLength > 8) {
            throw new ParseException("byte can only contain max 8 bits");
        }
        try {
            return (byte) bis.readBits(bitLength);
        } catch (IOException e) {
            throw new ParseException("Error reading", e);
        }
    }

    public short readShort(int bitLength) throws ParseException {
        if(bitLength <= 0) {
            throw new ParseException("short must contain at least 1 bit");
        }
        if(bitLength > 16) {
            throw new ParseException("short can only contain max 16 bits");
        }
        try {
            return (short) bis.readBits(bitLength);
        } catch (IOException e) {
            throw new ParseException("Error reading", e);
        }
    }

    public int readInt(int bitLength) throws ParseException {
        if(bitLength <= 0) {
            throw new ParseException("int must contain at least 1 bit");
        }
        if(bitLength > 32) {
            throw new ParseException("int can only contain max 32 bits");
        }
        try {
            return (int) bis.readBits(bitLength);
        } catch (IOException e) {
            throw new ParseException("Error reading", e);
        }
    }

    public long readLong(int bitLength) throws ParseException {
        if(bitLength <= 0) {
            throw new ParseException("long must contain at least 1 bit");
        }
        if(bitLength > 64) {
            throw new ParseException("long can only contain max 64 bits");
        }
        try {
            return bis.readBits(bitLength);
        } catch (IOException e) {
            throw new ParseException("Error reading", e);
        }
    }

    public BigInteger readBigInteger(int bitLength) throws ParseException {
        throw new UnsupportedOperationException("not implemented yet");
    }

    public float readFloat(int bitLength) throws ParseException {
        throw new UnsupportedOperationException("not implemented yet");
    }

    public double readDouble(int bitLength) throws ParseException {
        throw new UnsupportedOperationException("not implemented yet");
    }

    public BigDecimal readBigDecimal(int bitLength) throws ParseException {
        throw new UnsupportedOperationException("not implemented yet");
    }

}
