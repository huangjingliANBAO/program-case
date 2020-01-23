package week4;

/**
 * @Description TODO
 * @Author jl_huang
 * @Date 2020-01-19
 **/
public class Max {
    private static int max;
    public int getMax(int a, int b){
        max = Math.max(a,b);
        return max;
    }
    public void print(){
        System.out.println("最大值是：" + max);
    }
}