package org.mcclone.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URL;

/**
 * Created by mcclone on 17-7-16.
 */
public abstract class HdfsUtils {

    public static void copyFromLocalFile(String localPath, String hdfsPath) throws IOException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(configuration);

        Path dstPath = new Path(hdfsPath);
        if (!fileSystem.exists(dstPath)) {
            fileSystem.mkdirs(dstPath);
        }

        Path srcPath = new Path(localPath);
        fileSystem.copyFromLocalFile(srcPath, dstPath);
        fileSystem.close();
    }

    public static void copyFromLocalResourceFile(String resource, String hdfsPath) throws IOException {
        URL url = HdfsUtils.class.getResource(resource);
        String localPath = url.getPath();
        copyFromLocalFile(localPath, hdfsPath);
    }

}
