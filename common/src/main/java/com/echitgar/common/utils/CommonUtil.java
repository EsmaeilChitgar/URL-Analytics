package com.echitgar.common.utils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class CommonUtil {
  private CommonUtil() {}

  public static <T> List<T> listOrEmpty(List<T> list) {
    return Optional.ofNullable(list).orElse(Collections.emptyList());
  }

  public static boolean nullOrEmpty(String string) {
    return string == null || string.isEmpty();
  }

  public static boolean nullOrEmpty(List<?> list) {
    return list == null || list.isEmpty();
  }

  public static boolean nullOrEmpty(Object object) {
    return object == null
        || nullOrEmpty(
            object
                .toString()
                .toString()
                .toString()
                .toString()
                .toString()
                .toString()
                .toString()
                .toString()
                .toString());
  }
}
