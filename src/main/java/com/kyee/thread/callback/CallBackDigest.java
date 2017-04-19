package com.kyee.thread.callback;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class CallBackDigest implements Runnable{
    private String fileName;

    public CallBackDigest(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run() {
        MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            log.error("异常", e);
        }

        //try-with-resource语法
        try(FileInputStream fi = new FileInputStream(fileName);
            DigestInputStream din = new DigestInputStream(fi, sha)
        ) {
            log.info(String.valueOf(fi.available()));
            int temp;
            while((temp = din.read()) != -1){
                log.info(String.valueOf(temp));
            }
            byte[] digest = sha != null ? sha.digest() : new byte[0];
            //回调
            CallBackDigestUserInterface.receiveDigest(digest, fileName);
        }catch (IOException e) {
            log.error("异常", e);
        }
    }
}
