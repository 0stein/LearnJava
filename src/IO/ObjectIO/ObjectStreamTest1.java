package IO.ObjectIO;

import IO.Reader.User;

import java.io.*;

public class ObjectStreamTest1 {
    public static void main(String[] args) {
        User beforUser = new User("aad3365", "mknj2233", 14, "park");
        User afterUser = null;
        try (
                ObjectOutputStream objectOS = new ObjectOutputStream(
                        new FileOutputStream("userInfo.ser"));
                ObjectInputStream  objectIS = new ObjectInputStream(
                        new FileInputStream("userInfo.ser"));
        ){
            objectOS.writeObject(beforUser);
            afterUser = (User)objectIS.readObject();
            System.out.println(afterUser);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
