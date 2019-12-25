/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SemesterProject;

/**
 *
 * @author Xam 3xPloiTeR
 */
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class ResourceManager {
    SaveData temp;
    public ResourceManager() {
    }
    
    public  void savedata(Object data,String name) throws Exception{
        
    try{
        FileOutputStream fos = new FileOutputStream(name);
        try (ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(data);
            out.flush();
            out.close();
        }
          
           
    }
    catch(IOException e) {
    e.getStackTrace();
    }
    }
    public  Object loaddata(String name)throws Exception{
        
        try {
            FileInputStream fis=new FileInputStream(name);
            ObjectInputStream in = new ObjectInputStream(fis) ;
            Object temp =  in.readObject();
            in.close();
            return temp ;
            
        }   
    
    catch(IOException | ClassNotFoundException e ) {
    System.out.println("No Save File Found");
    }
        return null;
    }
}

//try{
//        FileOutputStream fos = new FileOutputStream("xam.bin");
//        ObjectOutputStream out =new ObjectOutputStream(fos);
//           out.writeObject(data);
//           out.close();
//           fos.close();
//    }
//    catch(IOException e) {
//    e.getStackTrace();
//    }
//    }
//    public static SaveData loaddata()throws Exception{
//    try{
//        FileInputStream ois =  new FileInputStream("xam.bin");
//        ObjectInputStream in =new ObjectInputStream(ois);
//        temp = (SaveData)   in.readObject() ;
//        in.close();
//        ois.close();
//    }
//    catch(IOException | ClassNotFoundException e) {
//    e.getStackTrace();
//    }
//    return temp;
//    }
