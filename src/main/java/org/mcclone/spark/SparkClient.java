package org.mcclone.spark;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.SparkSession;

import java.util.Arrays;

/**
 * Created by mcclone on 17-7-16.
 */
public class SparkClient {

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("SparkClient")
                .getOrCreate();

        JavaSparkContext sc = new JavaSparkContext(spark.sparkContext());
        JavaRDD<Integer> javaRDD = sc.parallelize(Arrays.asList(1, 2, 3, 4, 5));
        long count = javaRDD.count();
        System.out.println(count);
        spark.stop();
    }
}
