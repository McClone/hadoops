package org.mcclone.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import static org.apache.spark.sql.functions.col;

/**
 * Created by mcclone on 17-7-16.
 */
public class SparkSqlClient {

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("SQL Client")
                .master("local")
                .getOrCreate();

        Dataset<Row> df = spark.read().json("src/main/resources/people.json");
        df.printSchema();
        df.show();

        Row row = df.filter(col("age").isNotNull()).first();
        System.out.println(row.getAs("name").toString());

        df.createOrReplaceTempView("people");
        Dataset<Row> sqlDF = spark.sql("SELECT sum(age) FROM people group by name");
        sqlDF.show();
    }
}
