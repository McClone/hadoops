package org.mcclone.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;

/**
 * Created by mcclone on 17-9-23.
 */
public class HdfsWriteTxtClient {

    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(configuration);
        Path path = new Path("/user/mcclone/data/2.txt");
        FSDataOutputStream fsDataOutputStream = fileSystem.create(path);
        for (int i = 0; i < 100; i++) {
            fsDataOutputStream.writeBytes(String.valueOf(i) + "\n");
        }
        fsDataOutputStream.close();
        fileSystem.close();
    }
}
