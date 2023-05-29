package com.example.student_mgmt_system.utils;

import java.util.regex.Pattern;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Utils {

    public static final String EMAIL_REGEX = "^[A-Za-z0-9._+%-]+@[A-Za-z0-9.-]+[.][A-Za-z]+$";

    /**
     * Method used to regex check an email
     */
    public static boolean patternMatches(String email) {
        return Pattern.compile(EMAIL_REGEX)
            .matcher(email)
            .matches();
    }
}
