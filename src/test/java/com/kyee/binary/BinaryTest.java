package com.kyee.binary;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class BinaryTest {

    @Test
    public void testLeftMoveBit(){
        Assert.assertEquals(2, 1<<1);
        log.info("1 << 1 : " + (1<<1));
        log.info("1 << 2 : " + (1<<2));

        Assert.assertEquals(1024, 1<<10);
        log.info("1 << 10 : " + (1<<10));

        Assert.assertEquals(1024*1024, 1<<20);
        log.info("1 << 20 : " + (1<<20));

        log.info("^ : 异或操作, 2^30 = "+ (2^30));
        Assert.assertEquals(2^30, 28);

        Assert.assertEquals((int) Math.pow(2, 30), 1<<30);
        log.info("1 << 30 : " + (1 << 30));
        log.info("Integer Max : "+ Integer.MAX_VALUE);

        log.info("1 << 31 : "+ (1 << 31));
    }

    @Test
    public void testRightMoveBits(){
        int num = (int)Math.pow(2, 30);
        log.info(""+num);
//        >>表示右移，如果该数为正，则高位补0，若为负数，则高位补1；
//        >>>表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0。
        log.info("2^30 >>> 1 : " + (num >>> 1));
        log.info("2^30 >> 1 : " + (num >> 1));
        log.info("2^30 >>> 2 : " + (num >>> 2));
        log.info("2^30 >>> 3 : " + (num >>> 3));
        log.info("2^30 >>> 4 : " + (num >>> 4));
    }

    @Test
    public void testTableSizeFor() {
        log.info(""+tableSizeFor((int)Math.pow(2, 30)-1));
    }

    private int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    private static final int MAXIMUM_CAPACITY = 1 << 30;
}
