package org.mcclone;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.apache.commons.lang.RandomStringUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/10/6.
 */
public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(20));
        for (int i = 0; i < 5; i++) {
            ListenableFuture<String> future = executorService.submit(() -> RandomStringUtils.randomNumeric(2));
            System.out.println(future.get());
        }
    }
}
