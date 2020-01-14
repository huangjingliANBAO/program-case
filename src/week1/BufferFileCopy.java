package week1;

import java.io.*;

/**
 * @ClassName BufferFileCopy
 * @Description 使用缓冲流实现文件的copy
 * @Author jingli
 * @Date 2020-01-14
 **/
public class BufferFileCopy {
    public static void main(String[] args) {
        String filepath = System.getProperty("user.dir");
        BufferedReader bis = null;
        BufferedWriter bos = null;
        try{
            //使用字符缓冲流装饰一下
            bis = new BufferedReader(new FileReader(filepath + "\\data.txt"));
            bos = new BufferedWriter(new FileWriter(filepath + "\\copy.txt"));
            //设置临时变量
            int temp;
            while ((temp = bis.read()) != -1){
                bos.write(temp);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                bis.close();
                bos.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}