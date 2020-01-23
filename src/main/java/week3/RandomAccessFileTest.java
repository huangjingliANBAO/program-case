package week3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * @Description TODO
 * @Author jl_huang
 * @Date 2020-01-17
 **/
public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        path += "\\data2.txt";
        RandomAccessFile raf = new RandomAccessFile(new File(path), "r");
        new String(raf.readLine().getBytes("ISO-8859-1"), "UTF-8");
        int count = 0;
        while (true) {
            count++;
            String str = raf.readLine();
            // System.out.println(str);
            if (str.subSequence(0, str.length() - 1).equals("Host")) {
                System.out.println("Host:" + raf.readLine());
            }
            if (str.subSequence(0, str.length() - 1).equals("Content-Type")) {
                System.out.println("Content-Type:" + raf.readLine());
            }
            if (count == 18) {
                break;
            }

        }


//            if (str.subSequence(0, str.length() - 1).equals("Host")) {
//                System.out.println("Host:" + raf.readLine());
//            } else if (str.subSequence(0, str.length() - 1).equals("Content-Type")) {
//                System.out.println("Content-Type:" + raf.readLine());
//
//            }
//        }


//        int pointer = 200;
//        RandomAccessFile raf = new RandomAccessFile(path,"r");
//        //获取RandomAccessFile对象文件指针的位置，初始位置是0
//        System.out.println("RandomAccessFile文件指针的初始位置" + raf.getFilePointer());
//        //移动文件指针位置
//        raf.seek(pointer);
//        byte[] buff = new  byte[1024];
//        //用于保存实际读取的字节数
//        int hasRead = 0;
//        //循环读取
//        while ((hasRead = raf.read(buff)) > 0){
//            System.out.println(new String(buff,0,hasRead));
//        }
//    }
    }
}