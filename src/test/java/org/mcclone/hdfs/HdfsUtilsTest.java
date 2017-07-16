package org.mcclone.hdfs;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mcclone on 17-7-16.
 */
public class HdfsUtilsTest {
    @Test
    public void copyFromLocalResourceFile() throws Exception {
        HdfsUtils.copyFromLocalResourceFile("/people.json","/user/mcclone/data/");
    }

    @Test
    public void copyFromLocalFile() throws Exception {
        HdfsUtils.copyFromLocalFile("/usr/local/hadoop-2.7.3/README.txt","/user/mcclone/data/");
    }

}