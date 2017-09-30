package org.mcclone.hbase.coprocessor;

import org.apache.hadoop.hbase.client.Durability;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.coprocessor.BaseRegionObserver;
import org.apache.hadoop.hbase.coprocessor.ObserverContext;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessorEnvironment;
import org.apache.hadoop.hbase.regionserver.wal.WALEdit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * <p>
 * <property>
 * <name>hbase.coprocessor.region.classes</name>
 * <value>org.mcclone.hbase.coprocessor.MyRegionObserver</value>
 * </property>
 * <p>
 * </p>
 * Created by mcclone on 17-9-30.
 */
public class MyRegionObserver extends BaseRegionObserver {

    private static final Logger log = LoggerFactory.getLogger(MyRegionObserver.class);

    @Override
    public void postPut(ObserverContext<RegionCoprocessorEnvironment> e, Put put, WALEdit edit, Durability durability) throws IOException {
        log.info("MyRegionObserver");
    }
}
