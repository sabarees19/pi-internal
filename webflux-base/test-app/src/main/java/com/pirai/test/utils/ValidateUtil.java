package com.pirai.test.utils;

import org.springframework.web.multipart.MultipartFile;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author ashok
 * @author sabarees
 */
public final class ValidateUtil {

    private ValidateUtil() {
    }

    /**
     * Checks if the given BigDecimal number's sigNum is zero.
     * SigNum of a number indicates whether it's positive (1), negative (-1), or zero (0).
     *
     * @param number BigDecimal to check
     * @return {@code boolean} true if the number's sigNum is zero, false otherwise
     */
    public static boolean isSigNumZero(BigDecimal number) {
        return number.signum() == 0;
    }

    /**
     * Checks if the given integer is greater than zero.
     *
     * @param number Integer to check
     * @return {@code boolean} true if the number is greater than zero, false otherwise
     */
    public static boolean isGreaterThanZero(int number) {
        return number > 0;
    }

    /**
     * Checks if the right operand integer is less than the left operand integer.
     *
     * @param rightNum Right operand integer
     * @param leftNum  Left operand integer
     * @return {@code boolean} true if the right operand is less than the left operand, false otherwise
     */
    public static boolean checkIfSizeLess(int rightNum, int leftNum) {
        return rightNum < leftNum;
    }

    /**
     * Checks if the given integer is equal to zero.
     *
     * @param number Integer to check
     * @return {@code boolean} true if the number is equal to zero, false otherwise
     */
    public static boolean isEqualsZero(int number) {
        return number == 0;
    }

    /**
     * Checks if the given integer is greater than one.
     *
     * @param number Integer to check
     * @return {@code boolean} true if the number is greater than one, false otherwise
     */
    public static boolean isGreaterThanOne(int number) {
        return number > 1;
    }

    /**
     * Checks if the given BigDecimal number's sigNum is negative.
     * SigNum of a number indicates whether it's positive (1), negative (-1), or zero (0).
     *
     * @param rightNumber BigDecimal to check
     * @return {@code boolean} true if the number's sigNum is negative, false otherwise
     */
    public static boolean isSigNumNegative(BigDecimal rightNumber) {
        return rightNumber.signum() == -1;
    }

    /**
     * Checks if the given BigDecimal number's sigNum is positive.
     * SigNum of a number indicates whether it's positive (1), negative (-1), or zero (0).
     *
     * @param rightNumber BigDecimal to check
     * @return {@code boolean} true if the number's sigNum is positive, false otherwise
     */
    public static boolean isSigNumPositive(BigDecimal rightNumber) {
        return rightNumber.signum() == 1;
    }

    /**
     * Checks if the right operand BigDecimal is greater than the left operand BigDecimal.
     *
     * @param rightNumber Right operand BigDecimal
     * @param leftNumber  Left operand BigDecimal
     * @return {@code boolean} true if the right operand is greater than the left operand, false otherwise
     */
    public static boolean checkNumberGreaterThan(BigDecimal rightNumber, BigDecimal leftNumber) {
        return rightNumber.compareTo(leftNumber) > 0;
    }

    /**
     * Checks if the right operand BigDecimal is less than the left operand BigDecimal.
     *
     * @param rightNumber Right operand BigDecimal
     * @param leftNumber  Left operand BigDecimal
     * @return {@code boolean} true if the right operand is less than the left operand, false otherwise
     */
    public static boolean checkNumberLessThan(BigDecimal rightNumber, BigDecimal leftNumber) {
        return rightNumber.compareTo(leftNumber) < 0;
    }

    /**
     * Checks if the right operand BigDecimal is equal to the left operand BigDecimal.
     *
     * @param rightNumber Right operand BigDecimal
     * @param leftNumber  Left operand BigDecimal
     * @return {@code boolean} true if the right operand is equal to the left operand, false otherwise
     */
    public static boolean checkNumberEqual(BigDecimal rightNumber, BigDecimal leftNumber) {
        return rightNumber.compareTo(leftNumber) == 0;
    }

    /**
     * Checks if the right operand Integer is equal to the left operand Integer.
     *
     * @param rightNumber Right operand Integer
     * @param leftNumber  Left operand Integer
     * @return {@code boolean} true if the right operand is equal to the left operand, false otherwise
     */
    public static boolean checkNumberEqual(Integer rightNumber, Integer leftNumber) {
        return rightNumber.compareTo(leftNumber) == 0;
    }

    /**
     * Checks if the right operand Long is equal to the left operand Long.
     *
     * @param rightNumber Right operand Long
     * @param leftNumber  Left operand Long
     * @return {@code boolean} true if the right operand is equal to the left operand, false otherwise
     */
    public static boolean checkNumberEqual(Long rightNumber, Long leftNumber) {
        return rightNumber.compareTo(leftNumber) == 0;
    }

    /**
     * Checks if the given String is null or empty or blank (contains only whitespace).
     *
     * @param str String to check
     * @return {@code boolean} true if the String is null or empty or blank, false otherwise
     */
    public static boolean isNullEmpty(String str) {
        return str == null || str.isBlank();
    }

    /**
     * Checks if the given Long object is null.
     *
     * @param obj Long object to check
     * @return {@code boolean} true if the Long object is null, false otherwise
     */
    public static boolean isNullEmpty(Long obj) {
        return obj == null;
    }

    /**
     * Checks if the given StringBuilder is null or empty or contains only whitespace after conversion to String.
     *
     * @param sb StringBuilder to check
     * @return {@code boolean} true if the StringBuilder is null or empty or blank, false otherwise
     */
    public static boolean isNullEmpty(StringBuilder sb) {
        return sb == null || sb.toString().isBlank();
    }

    /**
     * Checks if the given Collection is null or empty.
     *
     * @param collection Collection to check
     * @return {@code boolean} true if the Collection is null or empty, false otherwise
     */
    public static boolean isNullEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * Checks if the given Map is null or empty.
     *
     * @param map Map to check
     * @return {@code boolean} true if the Map is null or empty, false otherwise
     */
    public static boolean isNullEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * Checks if the given BigDecimal value is null.
     *
     * @param value BigDecimal value to check
     * @return {@code boolean} true if the BigDecimal value is null, false otherwise
     */
    public static boolean isNullEmpty(BigDecimal value) {
        return value == null;
    }

    /**
     * Checks if the given object is null.
     *
     * @param obj Object to check
     * @return {@code boolean} true if the object is null, false otherwise
     */
    public static boolean isNullEmpty(Object obj) {
        return obj == null;
    }

    /**
     * Checks if the given List is null or empty.
     *
     * @param list List to check
     * @return {@code boolean} true if the List is null or empty, false otherwise
     */
    public static boolean isNullEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    /**
     * Checks if the given MultipartFile object is null or empty.
     *
     * @param obj MultipartFile object to check
     * @return {@code boolean} true if the MultipartFile is null or empty, false otherwise
     */
    public static boolean isNullEmpty(MultipartFile obj) {
        return obj == null || obj.isEmpty();
    }

    /**
     * Checks if the two Strings are equal ignoring case.
     *
     * @param rightWord Right operand String
     * @param leftWord  Left operand String
     * @return {@code boolean} true if the two Strings are equal ignoring case, false otherwise
     */
    public static boolean twoStringEqual(String rightWord, String leftWord) {
        return rightWord.equalsIgnoreCase(leftWord);
    }

    /**
     * Checks if the two Long values are equal.
     *
     * @param rightNum Right operand Long
     * @param leftNum  Left operand Long
     * @return {@code boolean} true if the two Long values are equal, false otherwise
     */
    public static boolean checkTwoLongEqual(Long rightNum, Long leftNum) {
        return rightNum.longValue() == leftNum.longValue();
    }

    /**
     * Checks if the right operand java.sql.Date object is before the left operand java.sql.Date object.
     *
     * @param rightDate Right operand java.sql.Date
     * @param leftDate  Left operand java.sql.Date
     * @return {@code boolean} true if the right date is before the left date, false otherwise
     */
    public static boolean checkIfDateIsBefore(java.sql.Date rightDate, java.sql.Date leftDate) {
        return rightDate.before(leftDate);
    }

    /**
     * Checks if the right operand java.sql.Date object is before the left operand java.sql.Timestamp object.
     *
     * @param rightDate Right operand java.sql.Date
     * @param leftDate  Left operand java.sql.Timestamp
     * @return {@code boolean} true if the right date is before the left timestamp, false otherwise
     */
    public static boolean checkIfDateIsBeforeTimestamp(java.sql.Date rightDate, java.sql.Timestamp leftDate) {
        return rightDate.before(leftDate);
    }

    /**
     * Checks if the right operand java.sql.Date object is equal to the left operand java.sql.Date object.
     *
     * @param rightDate Right operand java.sql.Date
     * @param leftDate  Left operand java.sql.Date
     * @return {@code boolean} true if the two dates are equal, false otherwise
     */
    public static boolean checkIfDateIsEqual(java.sql.Date rightDate, java.sql.Date leftDate) {
        return rightDate.equals(leftDate);
    }

    /**
     * Checks if the right operand java.sql.Date object is equal to the left operand java.sql.Timestamp object using their Instant representations.
     *
     * @param rightDate Right operand java.sql.Date
     * @param leftDate  Left operand java.sql.Timestamp
     * @return {@code boolean} true if the two dates are equal, false otherwise
     */
    public static boolean checkIfDateIsEqualTimestamp(java.sql.Date rightDate, java.sql.Timestamp leftDate) {
        return rightDate.toInstant().equals(leftDate.toInstant());
    }

    /**
     * Checks if the right operand java.sql.Date object is after the left operand java.sql.Date object.
     *
     * @param rightDate Right operand java.sql.Date
     * @param leftDate  Left operand java.sql.Date
     * @return {@code boolean} true if the right date is after the left date, false otherwise
     */
    public static boolean checkIfDateIsAfter(java.sql.Date rightDate, java.sql.Date leftDate) {
        return rightDate.after(leftDate);
    }

    /**
     * Checks if the right operand java.sql.Date object is after the left operand java.sql.Timestamp object.
     *
     * @param rightDate Right operand java.sql.Date
     * @param leftDate  Left operand java.sql.Timestamp
     * @return {@code boolean} true if the right date is after the left timestamp, false otherwise
     */
    public static boolean checkIfDateIsAfterTimestamp(java.sql.Date rightDate, java.sql.Timestamp leftDate) {
        return rightDate.after(leftDate);
    }

    /**
     * Checks if the right operand java.sql.Timestamp object is before the left operand java.sql.Timestamp object.
     *
     * @param rightDate Right operand java.sql.Timestamp
     * @param leftDate  Left operand java.sql.Timestamp
     * @return {@code boolean} true if the right timestamp is before the left timestamp, false otherwise
     */
    public static boolean checkIfTimestampIsBefore(java.sql.Timestamp rightDate, java.sql.Timestamp leftDate) {
        return rightDate.before(leftDate);
    }

    /**
     * Checks if the right operand java.sql.Timestamp object is equal to the left operand java.sql.Timestamp object.
     *
     * @param rightDate Right operand java.sql.Timestamp
     * @param leftDate  Left operand java.sql.Timestamp
     * @return {@code boolean} true if the two timestamps are equal, false otherwise
     */
    public static boolean checkIfTimestampIsEqual(java.sql.Timestamp rightDate, java.sql.Timestamp leftDate) {
        return rightDate.equals(leftDate);
    }

    /**
     * Checks if the right operand java.sql.Timestamp object is after the left operand java.sql.Timestamp object.
     *
     * @param rightDate Right operand java.sql.Timestamp
     * @param leftDate  Left operand java.sql.Timestamp
     * @return {@code boolean} true if the right timestamp is after the left timestamp, false otherwise
     */
    public static boolean checkIfTimestampIsAfter(java.sql.Timestamp rightDate, java.sql.Timestamp leftDate) {
        return rightDate.after(leftDate);
    }

    /**
     * Checks if the given array is null or empty.
     *
     * @param arr Array to check
     * @return {@code boolean} true if the array is null or empty, false otherwise
     */
    public static boolean isNullEmpty(Object[] arr) {
        return arr == null || arr.length == 0;
    }

    /**
     * Checks if the given integer is positive.
     *
     * @param num Integer to check
     * @return {@code boolean} true if the number is positive, false otherwise
     */
    public static boolean isPositive(int num) {
        return num > 0;
    }

    /**
     * Checks if the given BigDecimal number is positive.
     *
     * @param num BigDecimal to check
     * @return {@code boolean} true if the number is positive, false otherwise
     */
    public static boolean isPositive(BigDecimal num) {
        return num.compareTo(BigDecimal.ZERO) > 0;
    }

    /**
     * Checks if the given integer is negative.
     *
     * @param num Integer to check
     * @return {@code boolean} true if the number is negative, false otherwise
     */
    public static boolean isNegative(int num) {
        return num < 0;
    }

    /**
     * Checks if the given BigDecimal number is negative.
     *
     * @param num BigDecimal to check
     * @return {@code boolean} true if the number is negative, false otherwise
     */
    public static boolean isNegative(BigDecimal num) {
        return num.compareTo(BigDecimal.ZERO) < 0;
    }

    /**
     * Checks if the given integer is equal to zero.
     *
     * @param num Integer to check
     * @return {@code boolean} true if the number is equal to zero, false otherwise
     */
    public static boolean equalToZero(int num) {
        return num == 0;
    }

    /**
     * Checks if the given BigDecimal number is equal to zero.
     *
     * @param num BigDecimal to check
     * @return {@code boolean} true if the number is equal to zero, false otherwise
     */
    public static boolean equalToZero(BigDecimal num) {
        return num.compareTo(BigDecimal.ZERO) == 0;
    }

}
