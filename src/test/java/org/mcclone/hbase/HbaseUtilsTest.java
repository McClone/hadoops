package org.mcclone.hbase;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.junit.Test;

/**
 * Created by mcclone on 17-7-16.
 */
public class HbaseUtilsTest {

    @Test
    public void createSchemaTables() throws Exception {
        HbaseUtils.createSchemaTables("mytable", "B");

        for (TableName tableName : HbaseUtils.getAdmin().listTableNames()) {
            System.out.println(tableName.getNameAsString());
        }
    }

    @Test
    public void printResultScanner() throws Exception {
        Connection connection = HbaseUtils.getConnection();
        Table table = connection.getTable(TableName.valueOf("test"));
        Scan scan = new Scan();
        ResultScanner results = table.getScanner(scan);
        HbaseUtils.printResultScanner(results);
    }

}