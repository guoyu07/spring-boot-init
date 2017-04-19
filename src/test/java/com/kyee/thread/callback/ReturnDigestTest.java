package com.kyee.thread.callback;

import org.junit.Test;

import java.net.URL;

public class ReturnDigestTest {

    @Test
    public void testReturnDigest(){
        URL classPath = this.getClass().getResource("");
        String prefix = classPath.getPath();
        String[] args = new String[]{prefix.substring(1,prefix.length()) + "ReturnDigestTest.class"};
        System.out.println(args[0]);
        ReturnDigestUserInterface.handler(args);
    }
}
