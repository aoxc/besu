/*
 * Copyright contributors to Hyperledger Besu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 */
package org.hyperledger.besu.ethereum.api.jsonrpc.internal.parameters;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class JsonCallParameterTest {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  public void acceptsAndCapMaxValueForGasLimit() throws JsonProcessingException {
    final String json =
        """
        {
          "gas": "0xffffffffffffffff"
        }
        """;

    final JsonCallParameter callParameter = objectMapper.readValue(json, JsonCallParameter.class);

    assertThat(callParameter.getGasLimit()).isEqualTo(Long.MAX_VALUE);
  }
}
