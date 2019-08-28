package com.pacsun.util;

import java.io.IOException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncodingUtil
{
  public static String encode(String str)
  {
    BASE64Encoder encoder = new BASE64Encoder();
    str = new String(encoder.encodeBuffer(str.getBytes()));
    return str;
  }

  public static String decode(String str) {
    BASE64Decoder decoder = new BASE64Decoder();
    try {
      str = new String(decoder.decodeBuffer(str));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return str;
  }
}

/* Location:           C:\eclipse_workspace\HingeTo\Custom\QUA\lib\ps_hingeto_common.jar
 * Qualified Name:     com.pacsun.util.EncodingUtil
 * JD-Core Version:    0.6.0
 */