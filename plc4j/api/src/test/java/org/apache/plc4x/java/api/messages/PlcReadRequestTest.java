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
package org.apache.plc4x.java.api.messages;

import org.apache.plc4x.java.api.messages.items.ReadRequestItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

class PlcReadRequestTest {

    @Test
    void constuctor() {
        new PlcReadRequest();
        new PlcReadRequest(new ReadRequestItem<>(String.class, null));
        new PlcReadRequest(String.class, null);
        new PlcReadRequest(String.class, null, 13);
        new PlcReadRequest(Collections.singletonList(new ReadRequestItem<>(String.class, null)));
    }

    @Test
    void builder() {
        { // empty
            Assertions.assertThrows(IllegalStateException.class, () -> PlcReadRequest.builder().build());
        }
        { // one item
            PlcReadRequest.builder()
                .addItem(String.class, null)
                .build();
        }
        { // one item sized
            PlcReadRequest.builder()
                .addItem(String.class, null, 13)
                .build();
        }
        { // one item prebuild
            PlcReadRequest.builder()
                .addItem(new ReadRequestItem<>(String.class, null))
                .build();
        }
        { // two different item
            PlcReadRequest.builder()
                .addItem(String.class, null)
                .addItem(Byte.class, null)
                .build();
        }
        { // two different item typeSafe
            Assertions.assertThrows(IllegalStateException.class, () -> {
                PlcReadRequest.builder()
                    .addItem(String.class, null)
                    .addItem(Byte.class, null)
                    .build(String.class);
            });
        }
        { // two different item typeSafe
            Assertions.assertThrows(ClassCastException.class, () -> {
                PlcReadRequest.builder()
                    .addItem(String.class, null)
                    .addItem(Byte.class, null)
                    .build(Byte.class);
            });
        }
        { // two equal item typeSafe
            PlcReadRequest.builder()
                .addItem(Byte.class, null)
                .addItem(Byte.class, null)
                .build(Byte.class);
        }
    }

}