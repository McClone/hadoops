package org.mcclone.kafka;

import org.apache.commons.io.IOUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

public class ConsumerFileClient {

    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.put("bootstrap.servers", "dev:9092");
        props.put("group.id", "test-consumer-group");
        props.put("enable.auto.commit", "false");
        props.put("auto.commit.interval.ms", "1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.ByteArrayDeserializer");
        KafkaConsumer<String, byte[]> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("test-file"));
        while (true) {
            ConsumerRecords<String, byte[]> records = consumer.poll(100);
            for (ConsumerRecord<String, byte[]> record : records) {
                FileOutputStream output = new FileOutputStream(new File("D:\\tmp\\" + record.key()));
                IOUtils.write(record.value(), output);
                output.close();
                System.out.printf("offset = %d, key = %s", record.offset(), record.key());
            }
        }
    }
}
