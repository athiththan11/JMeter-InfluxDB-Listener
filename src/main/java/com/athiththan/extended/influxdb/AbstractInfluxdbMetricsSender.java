package com.athiththan.extended.influxdb;

abstract class AbstractInfluxdbMetricsSender implements InfluxdbMetricsSender {

    /**
     * For tag keys, tag values always use a backslash character \ to escape List of
     * special characters : commas , equal sign = spaces
     */
    static final String tagToStringValue(String s) {
        return s.trim().replaceAll(" ", "\\\\ ").replaceAll(",", "\\\\,").replaceAll("=", "\\\\=");
    }

    /**
     * For field always use a backslash character \ to escape " caractere
     */
    static final String fieldToStringValue(String s) {
        return s.trim().replaceAll("\"", "\\\\\"");
    }
}
