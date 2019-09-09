package cn.bolianlai.test;

public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i<1000; i++) {
                    if (i == 5) {
                        Thread.currentThread().interrupt();
                        System.out.println("@" + Thread.currentThread().isInterrupted());
                    }
                    System.out.println("###########"+i);
                }
            }
        });
        System.out.println(thread.isInterrupted());

        thread.start();
        System.out.println(thread.getState());
        System.out.println("#" + thread.isInterrupted());
        System.out.println(thread.getState());


    }
}
