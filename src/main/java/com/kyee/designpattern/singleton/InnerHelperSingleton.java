package com.kyee.designpattern.singleton;

class InnerHelperSingleton {
    private InnerHelperSingleton(){}

    private static class SingletonHelper{
        private static final InnerHelperSingleton INSTANCE = new InnerHelperSingleton();
    }

    public static InnerHelperSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
