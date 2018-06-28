package com.xxz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: Administrator
 * @Date: 2018/6/27 0027 20:44
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadTest {
    @Test
    public void threadTest() {
        ThreadTestDome threadTestDome1 = new ThreadTestDome();
        threadTestDome1.start();
        ThreadTestDome threadTestDome2 = new ThreadTestDome();
        threadTestDome2.start();
    }

    class ThreadTestDome extends Thread {
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 5; i++) {
                System.out.println(this.getName() + ":" + i);
            }
        }
    }
}
