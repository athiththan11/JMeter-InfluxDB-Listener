package com.athiththan.extended.influxdb;

interface InfluxdbMetricsSender {

    /**
     * One data point in InfluxDB is represented by a measurement name, a tag set
     * and a field set ( optionally a timestamp )
     */
    final class MetricTuple {
        String measurement;
        String tag;
        String field;
        long timestamp;

        MetricTuple(String measurement, String tag, String field, long timestamp) {
            this.measurement = measurement;
            this.tag = tag;
            this.field = field;
            this.timestamp = timestamp;
        }
    }

    /**
     * @param measurement name of the influxdb measurement
     * @param tag         tag set for influxdb
     * @param field       field set for influxdb
     */
    public void addMetric(String measurement, String tag, String field);

    /**
     * Write metrics to Influxdb with HTTP API with InfluxDB's Line Protocol
     */
    public void writeAndSendMetrics();

    /**
     * Setup sender using influxDBUrl
     * 
     * @param influxDBUrl url pointing to influxdb
     * @throws Exception when setup fails
     */
    public void setup(String influxDBUrl) throws Exception; // NOSONAR

    /**
     * Destroy sender
     */
    public void destroy();

}
