/*
 * Copyright (c) 2008-2015, Hazelcast, Inc. All Rights Reserved.
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

package com.hazelcast.client.impl.protocol.template;

import com.hazelcast.annotation.GenerateCodec;
import com.hazelcast.annotation.Request;
import com.hazelcast.client.impl.protocol.ResponseMessageConst;
import com.hazelcast.client.impl.protocol.parameters.TemplateConstants;
import com.hazelcast.nio.serialization.Data;

@GenerateCodec(id = TemplateConstants.XA_TRANSATION_TEMPLATE_ID, name = "XATransaction", ns = "XATransaction")
public interface XATransactionalCodecTemplate {

    @Request(id = 1, retryable = false, response = ResponseMessageConst.VOID)
    void clearRemote(Data xid);

    @Request(id = 2, retryable = false, response = ResponseMessageConst.LIST_DATA)
    void collectTransactions();

    @Request(id = 3, retryable = false, response = ResponseMessageConst.VOID)
    void finalize(Data xid, boolean isCommit);

    @Request(id = 4, retryable = false, response = ResponseMessageConst.INTEGER)
    void commit(String transactionId, boolean onePhase);

    @Request(id = 5, retryable = false, response = ResponseMessageConst.STRING)
    void create(Data xid, long timeout);

    @Request(id = 6, retryable = false, response = ResponseMessageConst.INTEGER)
    void prepare(String transactionId);

    @Request(id = 7, retryable = false, response = ResponseMessageConst.INTEGER)
    void rollback(String transactionId);
}
