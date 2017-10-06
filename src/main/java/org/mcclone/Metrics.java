package org.mcclone;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/10/6.
 */
public class Metrics {

    private static final MetricRegistry metrics = new MetricRegistry();

    private static ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics).build();

    public static void main(String[] args) throws InterruptedException {
        reporter.start(3, TimeUnit.SECONDS);
        Timer timer = metrics.timer("timer");

        for (int i = 0; i < 5; i++) {
            Timer.Context context = timer.time();
            try {
                Thread.sleep(RandomUtils.nextLong(3000, 4000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            context.stop();
        }

//        Histogram histogram = metrics.histogram(MetricRegistry.name("histogram"));
//        for (int i = 0; i < 5; i++) {
//            Thread thread = new Thread(() -> {
//                histogram.update(RandomUtils.nextInt(1, 100));
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//            thread.start();
//            thread.join();
//        }
    }
}
