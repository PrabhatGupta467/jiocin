package com.example.jiocin;

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class NudgeResponse implements Runnable {
    private volatile String resp;
    String myUrl="https://pp-api-raasgw.jio.com/v2/fetchdetails/";
    String ACCESS_TOKEN;
    @Override
    public void run() {
        try {
            TokenGenerater tokenGenerater=new TokenGenerater();
            ACCESS_TOKEN=tokenGenerater.generateToken();
            Log.e("token",ACCESS_TOKEN);
            URL url = new URL(myUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("X-Application-Name","1");
            conn.setRequestProperty("Authorization", ACCESS_TOKEN);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            String json="{\"buffer_type\":\"Request\", \"AppType\":4, \"buffer\":{ \"request_type\":4,\"Body\":{ \"ServiceInfo\":[{ \"DeviceType\":\"STB\", \"ServiceID\":1, \"Subscriberdetails\":[{ \"SubscriberId\":\"1000051032\", \"Personalized\":{ \"RecommType\":1}}]}]}}}";
            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
            os.writeBytes(json);
            os.flush();
            os.close();
            Log.e("STATUS", String.valueOf(conn.getResponseCode()));
            Log.e("MSG" , conn.getResponseMessage());
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                Log.e("Response",response.toString());
                resp=response.toString();
            }catch (Exception e){
                e.printStackTrace();
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String  getValue() {
        return resp;
    }
}
