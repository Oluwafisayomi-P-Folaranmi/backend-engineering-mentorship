package com.task_manager.utils;

public class StringUtils {
    public static String normalizeString(String stringText) {
        if (stringText == null) {
            return null;
        }
        String normalizedString = stringText.trim();
        return normalizedString.isEmpty() ? null : normalizedString;
    }
}
