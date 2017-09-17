package org.mcclone.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by mcclone on 17-7-16.
 */
public class SparkClient {

    public static void main(String[] args) throws IOException {
        SparkConf conf = new SparkConf()
                .setAppName("Simple Application")
                .setMaster("local");

        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> javaRDD = sc.parallelize(Arrays.asList("1", "2", "3", "4", "5"));
        javaRDD.distinct().foreach(System.out::println);
    }
}
