package com.kyee.thread.callback;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class ReturnDigest extends Thread{
    private String fileName;
    private byte[] digest;

    public ReturnDigest(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            FileInputStream fi = new FileInputStream(fileName);
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            DigestInputStream din = new DigestInputStream(fi,sha);
            while (din.read() != -1); //读取整个文件
            din.close();
            digest = sha.digest();
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public byte[] getDigest(){
        return digest;
    }
}
