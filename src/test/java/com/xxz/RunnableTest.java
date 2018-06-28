package com.xxz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: Administrator
 * @Date: 2018/6/28 0028 21:38
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RunnableTest {
    @Test
    public void runnableTest() {
        RunnableTestDemo runnableTestDemo = new RunnableTestDemo();
        new Thread(runnableTestDemo).start();

    }

    class RunnableTestDemo implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 6; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
