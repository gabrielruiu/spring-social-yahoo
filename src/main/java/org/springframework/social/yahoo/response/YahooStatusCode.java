package org.springframework.social.yahoo.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Enum which maps the response status codes with a flag which
 * indicates whether the response is an error ro not.
 *
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public enum YahooStatusCode {

    CODE_200(200, false),
    CODE_201(201, false),
    CODE_202(202, false),
    CODE_204(204, false),
    CODE_301(301, false),
    CODE_303(303, false),
    CODE_304(304, false),
    CODE_400(400),
    CODE_401(401),
    CODE_403(403),
    CODE_404(404),
    CODE_405(405),
    CODE_406(406),
    CODE_408(408),
    CODE_409(409),
    CODE_410(410),
    CODE_411(411),
    CODE_412(412),
    CODE_413(413),
    CODE_414(414),
    CODE_415(415),
    CODE_416(416),
    CODE_500(500),
    CODE_501(501),
    CODE_502(502),
    CODE_505(505);

    /**
     * The actual HTTP status code received from the Yahoo API
     */
    private int statusCode;

    /**
     * Flag which indicates whether the status code signals that the response is an error or not
     */
    private boolean isError;

    /**
     * @param statusCode the numeric value of the HTTP status code
     */
    YahooStatusCode(int statusCode) {
        this(statusCode, true);
    }

    /**
     * @param statusCode the numeric value of the HTTP status code
     * @param isError    flag whether the HTTP status code represents an error
     */
    YahooStatusCode(int statusCode, boolean isError) {
        this.statusCode = statusCode;
        this.isError = isError;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public boolean isError() {
        return isError;
    }

    /**
     * Get the list of status codes which are of type error
     *
     * @return list of status codes which are of type error
     */
    public static List<YahooStatusCode> errorStatuses() {
        return filterStatusCodes(true);
    }

    /**
     * Get the list of status codes which are of type success
     *
     * @return list of status codes which are of type success
     */
    public static List<YahooStatusCode> successStatuses() {
        return filterStatusCodes(false);
    }

    private static List<YahooStatusCode> filterStatusCodes(boolean isError) {
        List<YahooStatusCode> errorStatusCodes = new ArrayList<>();
        for (YahooStatusCode yahooStatusCode : values()) {
            if (isError == yahooStatusCode.isError()) {
                errorStatusCodes.add(yahooStatusCode);
            }
        }
        return errorStatusCodes;
    }
}
