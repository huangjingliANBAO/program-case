package week1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

/**
 * @ClassName RandomNumber
 * @Description 随机生成100个0-99的整型数据，存入本地文件
 * @Author jingli
 * @Date 2020-01-14
 **/
public class RandomNumber {
    public static void main(String[] args) {
        //获取本类在本地的位置
        String filepath = System.getProperty("user.dir");
        filepath += "\\data.txt";
        System.out.println(filepath);
        try {
            File file = new File(filepath);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("data.txt创建完成");
            }
            //字符输出流
            FileWriter fw = new FileWriter(file);
            //缓冲输出流
            BufferedWriter bw = new BufferedWriter(fw);
            //随机生成100个0-99的整型数据，并创建一个随机数种子
            Random random = new Random();
            for (int i = 0; i <= 99; i++) {
                int data = (int) Math.floor((random.nextDouble() * 99.0));
                //处理中文乱码
                bw.write(String.valueOf(data) + "  ");
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}