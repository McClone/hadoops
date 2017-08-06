package org.mcclone.hbase;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

/**
 * Created by mcclone on 17-8-6.
 */
public class FilterTest {

    @Test
    public void testRowFilter() throws Exception {
        Filter filter = new RowFilter(CompareFilter.CompareOp.EQUAL, new SubstringComparator("20170404001"));
        Connection connection = HbaseUtils.getConnection();
        Scan scan = new Scan();
        scan.setFilter(filter);
        Table table = connection.getTable(TableName.valueOf("test1"));
        ResultScanner resultScanner = table.getScanner(scan);
        HbaseUtils.printResultScanner(resultScanner);
        resultScanner.close();
    }

    @Test
    public void testPrefixFilter() throws Exception{
        Filter filter = new PrefixFilter(Bytes.toBytes("20170404"));
        Connection connection = HbaseUtils.getConnection();
        Scan scan = new Scan();
        scan.setFilter(filter);
        Table table = connection.getTable(TableName.valueOf("test1"));
        ResultScanner resultScanner = table.getScanner(scan);
        HbaseUtils.printResultScanner(resultScanner);
        resultScanner.close();
    }

    @Test
    public void test() throws Exception{
        Connection connection = HbaseUtils.getConnection();
        Filter filter = new PageFilter(1);
        Scan scan = new Scan();
        scan.setFilter(filter);
        Table table = connection.getTable(TableName.valueOf("test"));
        ResultScanner resultScanner = table.getScanner(scan);
        HbaseUtils.printResultScanner(resultScanner);
        resultScanner.close();
    }

}
