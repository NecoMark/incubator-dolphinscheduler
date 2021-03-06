/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dolphinscheduler.common.utils;


/**
 * http utils
 */
public class IpUtils {

  public static final String DOT = ".";

  /**
   * ip str to long <p>
   *
   * @param ipStr ip string
   * @return ip to long
   */
  public static Long ipToLong(String ipStr) {
    String[] ipSet = ipStr.split("\\" + DOT);

    return Long.parseLong(ipSet[0]) << 24 | Long.parseLong(ipSet[1]) << 16 | Long.parseLong(ipSet[2]) << 8 | Long.parseLong(ipSet[3]);
  }

  /**
   * long to ip
   * @param ipLong the long number converted from IP
   * @return String
   */
  public static String longToIp(long ipLong) {
    long[] ipNumbers = new long[4];
    long tmp = 0xFF;
    ipNumbers[0] = ipLong >> 24 & tmp;
    ipNumbers[1] = ipLong >> 16 & tmp;
    ipNumbers[2] = ipLong >> 8 & tmp;
    ipNumbers[3] = ipLong & tmp;

    String sb = ipNumbers[0] + DOT +
            ipNumbers[1] + DOT +
            ipNumbers[2] + DOT +
            ipNumbers[3];
    return sb;
  }

}
