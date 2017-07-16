package org.mcclone.hbase;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Base64;

import java.io.IOException;

/**
 * Created by mcclone on 17-3-12.
 */
public class HbaseClient {

    public static void main(String... args) {
        try {
            Connection connection = HbaseUtils.getConnection();
            Table table = connection.getTable(TableName.valueOf("test"));
            String rowKey = "20170404002001";
            Base64.decode(rowKey);
            Put put = new Put("MjAxNzA0MDQwMDIwMDE=".getBytes());
            put.addColumn("cf".getBytes(), "c1".getBytes(), "value1".getBytes());
            put.addColumn("cf".getBytes(), "c2".getBytes(), "value2".getBytes());
            table.put(put);
            table.getScanner("cf".getBytes()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
