/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practical22;
import java.util.HashMap;
import java.net.URL;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 *
 * @author Люба
 */
public class HTTPRunnable implements Runnable{
    private String address;
    private HashMap<String,String> requestBody;
    private String responseBody;

    public HTTPRunnable(String address, HashMap<String, String> requestBody) {
        this.address = address;
        this.requestBody = requestBody;
    }

    public String getResponseBody() {
        return responseBody;
    }
    @Override
    public void run(){
        if(this.address != null && !this.address.isEmpty()){
            try{
                URL url = new URL(this.address);
                URLConnection connection = url.openConnection();
                HttpURLConnection httpConnection = (HttpURLConnection)connection;
                httpConnection.setRequestMethod("GET");
                InputStreamReader isr = new InputStreamReader(httpConnection.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String currentLine;
                StringBuilder sbResponse = new StringBuilder();
                while((currentLine = br.readLine()) != null){
                    sbResponse.append(currentLine);
                }
                responseBody = sbResponse.toString();
            }catch(IOException ex){
                System.out.println("Error: " + ex.getMessage());
            }
        }
    }
    
}
