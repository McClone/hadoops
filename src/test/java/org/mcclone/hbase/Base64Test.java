package org.mcclone.hbase;

import org.apache.hadoop.hbase.util.Base64;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

/**
 * Created by mcclone on 17-7-16.
 */
public class Base64Test {

    @Test
    public void encode() throws Exception {
        String rowKey = "20170404002001";
        System.out.println(Base64.encodeBytes(Bytes.toBytes(rowKey)));
    }

    @Test
    public void decode() throws Exception {
        String rowKey = "MjAxNzA0MDQwMDIwMDE=";
        System.out.println(Bytes.toString(Base64.decode(rowKey)));
    }
}
