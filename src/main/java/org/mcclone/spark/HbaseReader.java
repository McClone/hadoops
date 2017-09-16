package org.mcclone.spark;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableInputFormat;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by mcclone on 17-9-16.
 */
public class HbaseReader {

    public static void main(String[] args) {
        Configuration hbaseConf = HBaseConfiguration.create();
        hbaseConf.set(TableInputFormat.INPUT_TABLE, "test");
        SparkConf conf = new SparkConf()
                .setAppName("Read Hbase")
                .setMaster("local");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaPairRDD<ImmutableBytesWritable, Result> hBaseRDD =
                sc.newAPIHadoopRDD(hbaseConf, TableInputFormat.class,
                        ImmutableBytesWritable.class, Result.class);

        System.out.println(hBaseRDD.count());
    }
}
