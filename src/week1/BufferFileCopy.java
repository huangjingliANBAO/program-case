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
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try{
            //使用缓冲流装饰一下
            bis = new BufferedInputStream(new FileInputStream(filepath + "\\data.txt"));
            bos = new BufferedOutputStream(new FileOutputStream(filepath + "\\copy.txt"));
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