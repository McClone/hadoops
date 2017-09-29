package org.mcclone.hdfs;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

/**
 * Created by mcclone on 17-9-23.
 */
public class HdfsTest {

    @Test
    public void testReadTxt() throws Exception {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(configuration);
        Path path = new Path("/user/mcclone/data/2.txt");
        FSDataInputStream fsDataInputStream = fileSystem.open(path);
        IOUtils.copy(fsDataInputStream, System.out);
    }
}
