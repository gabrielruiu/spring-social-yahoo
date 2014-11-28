package org.springframework.social.yahoo.module;

/**
 * Used for birthday and anniversary fields.
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@1and1.ro)
 */
public class DateFieldValue extends FieldValue {

    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
