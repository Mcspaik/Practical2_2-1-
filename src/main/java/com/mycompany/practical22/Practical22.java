/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.practical22;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Люба
 */
public class Practical22 {

    public static void main(String[] args) {
        System.out.println("РИБО-02-22, Степеренкова Любовь Алексеевна");
        System.out.println("Start program!!!!!!");
        String server = "https://www.mirea.ru/";
        HTTPRunnable httpRunnable = new HTTPRunnable(server,null);
        Thread th = new Thread(httpRunnable);
        th.start();
        try{
            th.join();
        }catch (InterruptedException ex){
            
        }finally{
            try{
                FileWriter fw = new FileWriter("C:\\для_крутых\\крутыши.html");
                fw.write(httpRunnable.getResponseBody());
                fw.close();
                System.out.println("Success save response from server:" + server);
            }catch (IOException ex){
                System.out.println("Error response saving: " + ex.getMessage());
            }
        }
    }
}
