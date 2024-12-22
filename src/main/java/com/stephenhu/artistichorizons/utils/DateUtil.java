package com.stephenhu.artistichorizons.utils;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * @author Stephen Hu
 * 日期封装类
 */
public final class DateUtil {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter YEAR_MONTH_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM");
    private static final DateTimeFormatter YEAR_FORMATTER = DateTimeFormatter.ofPattern("yyyy");

    /**
     * 将 yyyy-MM-dd 格式的字符串转换为 Date 对象
     *
     * @param dateStr 日期字符串
     * @return Date 对象
     * @throws IllegalArgumentException 如果日期字符串格式不正确
     */
    public static Date parseDate(String dateStr) {
        try {
            LocalDate localDate = LocalDate.parse(dateStr, DATE_FORMATTER);
            return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + dateStr + ". Expected format: yyyy-MM-dd", e);
        }
    }

    /**
     * 将 yyyy-MM 格式的字符串转换为 Date 对象
     *
     * @param yearMonthStr 年月字符串
     * @return Date 对象
     * @throws IllegalArgumentException 如果年月字符串格式不正确
     */
    public static Date parseYearMonth(String yearMonthStr) {
        try {
            YearMonth yearMonth = YearMonth.parse(yearMonthStr, YEAR_MONTH_FORMATTER);
            LocalDate firstDayOfMonth = yearMonth.atDay(1);
            return Date.from(firstDayOfMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid year-month format: " + yearMonthStr + ". Expected format: yyyy-MM", e);
        }
    }

    /**
     * 将 yyyy 格式的字符串转换为 Date 对象
     *
     * @param yearStr 年份字符串
     * @return Date 对象
     * @throws IllegalArgumentException 如果年份字符串格式不正确
     */
    public static Date parseYear(String yearStr) {
        try {
            Year year = Year.parse(yearStr, YEAR_FORMATTER);
            LocalDate firstDayOfYear = year.atDay(1);
            return Date.from(firstDayOfYear.atStartOfDay(ZoneId.systemDefault()).toInstant());
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid year format: " + yearStr + ". Expected format: yyyy", e);
        }
    }

    public static void main(String[] args) {
        // 测试 parseDate 方法
        try {
            Date date = parseDate("1987-10-01");
            System.out.println("Parsed Date: " + date);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // 测试 parseYearMonth 方法
        try {
            Date yearMonth = parseYearMonth("1987-10");
            System.out.println("Parsed Year-Month: " + yearMonth);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        // 测试 parseYear 方法
        try {
            Date year = parseYear("1987");
            System.out.println("Parsed Year: " + year);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
