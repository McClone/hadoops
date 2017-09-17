package org.mcclone.spark;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;

import java.util.Properties;

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

        Properties connectionProperties = new Properties();
        connectionProperties.put("user", "root");
        connectionProperties.put("password", "root");
        connectionProperties.put("driver", "com.mysql.jdbc.Driver");

        Dataset<Row> df = spark.read().json("hdfs://localhost:9000/user/mcclone/data/people.json");
        df.createOrReplaceTempView("people");
        Dataset<Row> sqlDF = spark.sql("SELECT sum(age) FROM people group by name");
        sqlDF.show();
        sqlDF.write().mode(SaveMode.Append).jdbc("jdbc:mysql://localhost:3309/demo", "people", connectionProperties);
    }
}
