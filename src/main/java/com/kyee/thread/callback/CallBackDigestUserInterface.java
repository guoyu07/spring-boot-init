package com.kyee.thread.callback;


import javax.xml.bind.DatatypeConverter;

public class CallBackDigestUserInterface {
    public static void handler(String[] args){
//        String[] ttt = new String[]{"D:/github/spring-boot-init/target/test-classes/com/kyee/thread/callback/CallBackDigestTest.class"};
        for(String fileName: args){
            CallBackDigest cb = new CallBackDigest(fileName);
            Thread t = new Thread(cb);
            t.start();
        }
    }

    public static void receiveDigest(byte[] digest, String fileName) {
        StringBuilder sb = new StringBuilder(fileName);
        sb.append(": ");
        sb.append(DatatypeConverter.printHexBinary(digest));
        System.out.println(sb);
    }
}
