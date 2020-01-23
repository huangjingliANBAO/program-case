package week1;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName RandomNumberIo
 * @Description 随机生成100个0-99的整型数据，存入本地文件
 * @Author jingli
 * @Date 2020-01-14
 **/
public class RandomNumberIo {
    private static final int LENGTH = 100;
    public static void main(String[] args)throws IOException{
        String filepath = System.getProperty("user.dir");
        filepath += "\\result.txt";
        int[] numbers = new int[LENGTH];
        Random random = new Random();
        for (int i = 0; i < LENGTH; i++) {
            numbers[i] = random.nextInt(LENGTH);
        }
        System.out.println(Arrays.toString(numbers));
        File file = new File(filepath);
        Writer writer = new FileWriter(file,true);
        PrintWriter out = new PrintWriter(writer);
        out.print(Arrays.toString(numbers));
        out.flush();
        out.close();
        writer.close();
    }
}