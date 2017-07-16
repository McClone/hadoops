package org.mcclone.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by mcclone on 17-7-16.
 */
public class HdfsClient {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(configuration);
        Path path = new Path("/user/mcclone/data/");
        if (!fileSystem.exists(path)) {
            fileSystem.mkdirs(path);
        }

        fileSystem.copyFromLocalFile(new Path("/usr/local/hadoop-2.7.3/README.txt"), path);
        fileSystem.close();
    }
}
