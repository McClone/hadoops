package org.mcclone.hbase;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mcclone on 17-6-19.
 */
public class FilterClient {

    public static void main(String[] args) {
        List<Filter> filters = new ArrayList<>();
        FilterList filterList = new FilterList(filters);
        Filter filter = new ValueFilter(CompareFilter.CompareOp.EQUAL, new SubstringComparator("1"));
        filters.add(filter);
        try {
            Connection connection = HbaseUtils.getConnection();
            Scan scan = new Scan();
            scan.setFilter(filterList);
            Table table = connection.getTable(TableName.valueOf("test"));
            ResultScanner resultScanner = table.getScanner(scan);
            HbaseUtils.printResultScanner(resultScanner);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
