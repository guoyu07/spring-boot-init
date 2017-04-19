package com.kyee.thread.callback;


import javax.xml.bind.DatatypeConverter;

//轮询：查询线程的返回结果
public class ReturnDigestUserInterface {

    public static void handler(String[] args){
        ReturnDigest[] digests = new ReturnDigest[args.length];

        for(int i=0;i<args.length;i++){
            //计算摘要
            digests[i] = new ReturnDigest(args[i]);
            digests[i].start();
        }

        for(int i=0;i<args.length;i++){
            //可能导致死循环
            while(true){
                byte[] digest = digests[i].getDigest();
                if(digest != null){
                    StringBuilder result = new StringBuilder(args[i]);
                    result.append(": ");
                    result.append(DatatypeConverter.printHexBinary(digest));
                    System.out.println(result);
                    break;
                }
            }
        }
    }
}
