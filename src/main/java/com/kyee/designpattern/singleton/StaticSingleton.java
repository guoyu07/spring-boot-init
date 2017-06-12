package com.kyee.designpattern.singleton;

class StaticSingleton {
    private static StaticSingleton instance;

    private StaticSingleton(){}

    static{
        try{
            instance = new StaticSingleton();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }

    public static StaticSingleton getInstance(){
        return instance;
    }
}
