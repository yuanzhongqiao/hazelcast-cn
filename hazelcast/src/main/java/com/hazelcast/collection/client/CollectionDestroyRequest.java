/*
 * Copyright (c) 2008-2012, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.collection.client;

import com.hazelcast.client.CallableClientRequest;
import com.hazelcast.client.RetryableRequest;
import com.hazelcast.collection.CollectionPortableHook;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;

import java.io.IOException;

/**
 * @ali 9/4/13
 */
public class CollectionDestroyRequest extends CallableClientRequest implements Portable, RetryableRequest {

    String name;

    String serviceName;

    public CollectionDestroyRequest() {
    }

    public CollectionDestroyRequest(String name) {
        this.name = name;
    }

    public Object call() throws Exception {
        return null;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getFactoryId() {
        return CollectionPortableHook.F_ID;
    }

    public int getClassId() {
        return CollectionPortableHook.COLLECTION_DESTROY;
    }

    public void writePortable(PortableWriter writer) throws IOException {
        writer.writeUTF("n",name);
        writer.writeUTF("s",serviceName);
    }

    public void readPortable(PortableReader reader) throws IOException {
        name = reader.readUTF("n");
        serviceName = reader.readUTF("s");
    }
}
