package main.java.serializable;

import java.io.*;


/**
 * 对象的序列化和反序列化
 *
 * @author Peddy
 * @time 2018-01-27 11:26
 */
public class ObjSerializeAndDeserialize {

    public void serializeObj() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\IntelliJ_WorkSpace_Java\\JavaProject-Peddy\\src\\main\\java\\serializable\\serialObj.txt"));
        PersonVO personVO = new PersonVO();
        personVO.setName("peddy");
        personVO.setAge("18");
        personVO.setAddress("shanghai,china");
        objectOutputStream.writeObject(personVO);
        System.out.println(personVO.toString());
    }

    public void deserializeObj() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:\\IntelliJ_WorkSpace_Java\\JavaProject-Peddy\\src\\main\\java\\serializable\\serialObj.txt"));
        PersonVO personVO = (PersonVO) objectInputStream.readObject();
        System.out.println(personVO.toString());
    }

    public static void main(String[] args) throws Exception {
        ObjSerializeAndDeserialize objSerial = new ObjSerializeAndDeserialize();
        objSerial.serializeObj();
        objSerial.deserializeObj();
    }


}
