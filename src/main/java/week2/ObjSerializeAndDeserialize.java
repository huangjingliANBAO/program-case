package week2;

import java.io.*;

/**
 * @Description 实现对象的序列化和反序列化
 * @Author jl_huang
 * @Date 2020-01-15
 **/
public class ObjSerializeAndDeserialize {
    private static String filePath = "D:\\student.txt";

    public static void  SerializeStudent(Student student)throws FileNotFoundException, IOException {
        //ObjectOutputStream对象输出流，将student对象存储到本地，从而实现对象序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath));
        oos.writeObject(student);
        oos.close();
    }
    public static Student DeserializeStudent()throws ClassNotFoundException,IOException{
        //ObjectInputStream对象输入流，将filePath的字节转为student对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath));
        Student student = (Student) ois.readObject();
        ois.close();
        return student;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //对象序列化
        Student student = new Student("1802343308","黄敬理","男","软件1851");
        SerializeStudent(student);
        //对象反序列化
        Student student1 = DeserializeStudent();
        System.out.println(student1);

    }
}