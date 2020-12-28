package com.athiththan.extended.influxdb;

import org.apache.jmeter.samplers.SampleResult;

class ExtendedInfluxMetric {

    private final String assetionFailureMessage;
    private final SampleResult sampleResult;
    private final String application;

    public ExtendedInfluxMetric(SampleResult result, String application) {
        this.sampleResult = result;
        this.application = application;
        this.assetionFailureMessage = result.getFirstAssertionFailureMessage();
    }

    public StringBuilder getMetrics() {
        return this.getOKFieldMetrics();
    }

    public StringBuilder getTags() {
        if (this.assetionFailureMessage == null) {
            return this.getOKTags();
        } else {
            return this.getOKTags().append(InfluxDBMetricConstants.TAG_ERROR_MESSAGE)
                    .append(this.assetionFailureMessage);
        }
    }

    private StringBuilder getOKFieldMetrics() {
        StringBuilder field = new StringBuilder(100);
        field.append(InfluxDBMetricConstants.METRIC_ERROR_COUNT).append(this.sampleResult.getErrorCount());
        field.append(",").append(InfluxDBMetricConstants.METRIC_COUNT).append(this.sampleResult.getSampleCount());
        field.append(",").append(InfluxDBMetricConstants.METRIC_RECEIVED_BYTES)
                .append(this.sampleResult.getBytesAsLong());
        field.append(",").append(InfluxDBMetricConstants.METRIC_SENT_BYTES).append(this.sampleResult.getSentBytes());
        field.append(",").append(InfluxDBMetricConstants.METRIC_RESPONSE_TIME).append(this.sampleResult.getTime());
        field.append(",").append(InfluxDBMetricConstants.METRIC_LATENCY).append(this.sampleResult.getLatency());
        field.append(",").append(InfluxDBMetricConstants.METRIC_CONNECT_TIME)
                .append(this.sampleResult.getConnectTime());
        field.append(",").append(InfluxDBMetricConstants.METRIC_PROCESSING_TIME)
                .append(this.sampleResult.getLatency() - this.sampleResult.getConnectTime());
        return field;
    }

    private StringBuilder getOKTags() {
        StringBuilder tag = new StringBuilder(80);
        tag.append(InfluxDBMetricConstants.TAG_APPLICATION_NAME).append(this.application);
        tag.append(InfluxDBMetricConstants.TAG_TRANSACTION)
                .append(AbstractInfluxdbMetricsSender.tagToStringValue(this.sampleResult.getSampleLabel()));
        tag.append(InfluxDBMetricConstants.TAG_RAW_RESPONSE_CODE).append(this.sampleResult.getResponseCode());
        return tag;
    }
}
