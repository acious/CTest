package com.jongchan.ctest.util;

public class StringUtil {
    public static boolean isNullOrEmpty(CharSequence str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        return false;
    }
}
