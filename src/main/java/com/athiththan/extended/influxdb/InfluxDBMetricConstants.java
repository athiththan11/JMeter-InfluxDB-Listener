package com.athiththan.extended.influxdb;

class InfluxDBMetricConstants {

    private InfluxDBMetricConstants() {
    }

    public static final String RAW_MEASUREMENT = "raw_transaction";

    public static final String TAG_RAW_RESPONSE_CODE = ",responseCode=";
    public static final String TAG_APPLICATION_NAME = ",application=";
    public static final String TAG_TRANSACTION = ",transaction=";
    public static final String TAG_ERROR_MESSAGE = ",errorMessage=";

    public static final String METRIC_COUNT = "count=";
    public static final String METRIC_ERROR_COUNT = "errorCount=";
    public static final String METRIC_RECEIVED_BYTES = "rb=";
    public static final String METRIC_SENT_BYTES = "sb=";
    public static final String METRIC_RESPONSE_TIME = "responseTime=";
    public static final String METRIC_PROCESSING_TIME = "processingTime=";
    public static final String METRIC_CONNECT_TIME = "connectTime=";
    public static final String METRIC_LATENCY = "latency=";
}
