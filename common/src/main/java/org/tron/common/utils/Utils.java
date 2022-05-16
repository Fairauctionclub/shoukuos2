package org.tron.common.utils;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Arrays;

public interface Utils {

  SecureRandom random = new SecureRandom();

  static SecureRandom getRandom() {
    return random;
  }

  

  static byte[] clone(byte[] value) {
    byte[] clone = new byte[value.length];
    System.arraycopy(value, 0, clone, 0, value.length);
    return clone;
  }

  static String align(String s, char fillChar, int targetLen, boolean alignRight) {
    if (targetLen <= s.length()) {
      return s;
    }
    String alignString = repeat("" + fillChar, targetLen - s.length());
    return alignRight ? alignString + s : s + alignString;

  }

  static String repeat(String s, int n) {
    if (s.length() == 1) {
      byte[] bb = new byte[n];
      Arrays.fill(bb, s.getBytes()[0]);
      return new String(bb);
    } else {
      StringBuilder ret = new StringBuilder();
      for (int i = 0; i < n; i++) {
        ret.append(s);
      }
      return ret.toString();
    }
  }
}
