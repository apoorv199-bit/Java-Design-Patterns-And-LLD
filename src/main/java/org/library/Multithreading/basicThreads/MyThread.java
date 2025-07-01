package org.library.Multithreading.basicThreads;

public class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run(){
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " - Count: " + i);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
