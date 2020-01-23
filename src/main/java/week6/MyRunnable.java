package week6;

/**
 * @Description 实现Runnable接口
 * @Author jl_huang
 * @Date 2020-01-22
 **/
public class MyRunnable implements Runnable {
    private int i = 0;
    @Override
    public void run() {
        while (true){
            i++;
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}