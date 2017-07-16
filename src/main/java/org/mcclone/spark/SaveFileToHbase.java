package org.mcclone.spark;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.mcclone.hbase.HbaseUtils;

import java.util.UUID;

/**
 * Created by mcclone on 17-7-16.
 */
public class SaveFileToHbase {

    public void saveToHbase() {
        SparkConf conf = new SparkConf()
                .setAppName("Save To Hbase")
                .setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> javaRDD = sc.textFile("hdfs://localhost:9000/user/mcclone/data/README.txt");

        javaRDD.foreach(x -> {
            Put put = new Put(UUID.randomUUID().toString().replaceAll("-", "").getBytes());
            put.addColumn("cf".getBytes(), "line".getBytes(), x.getBytes());
            Connection connection = HbaseUtils.getConnection();
            Table table = connection.getTable(TableName.valueOf("test"));
            table.put(put);
        });
    }

    public static void main(String[] args) {
        SaveFileToHbase saveFileToHbase = new SaveFileToHbase();
        saveFileToHbase.saveToHbase();
    }

}
