# JMeter InfluxDB Listener

An Extended InfluxDB Backend Listener Implementation for JMeter

## Metrics

- `maxAT`: Maximum active threads
- `minAT`: Minimum active threads
- `meanAT`: Mean active threads
- `startedT`: Number of started threads
- `endedT`: Ended threads
- `sb`: Sent bytes
- `rb`: Received bytes
- `responseTime`: Response time
- `processingTime`: Processing time
- `latency`: Latency
- `connectTime`: Connection time

## Build & Deploy

### Build

Execute the following command from the root directory of the project to build the project

```sh
mvn clean install package
```

### Deploy

Copy the built JAR artifact from the `/target` directory and place it inside the `<apache>/lib/ext` to engage the extended backend listener implementation with the JMeter.

## References

- [mderevyankoaqa/jmeter-influxdb-listener-plugin](https://github.com/mderevyankoaqa/jmeter-influxdb-listener-plugin)
- [ufctester/apache-jmeter](https://github.com/ufctester/apache-jmeter)
