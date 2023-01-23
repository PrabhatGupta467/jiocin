package com.example.jiocin;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class JioNudgeResponse {

    public void getResponse(Context context){
//        StringRequest request = new StringRequest(Request.Method.POST, "https://pp-api-raasgw.jio.com/v2/fetchdetails/", new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                if (!response.equals(null)) {
//                    Log.e("Your Array Response", response);
//                } else {
//                    Log.e("Your Array Response", "Data Null");
//                }
//            }
//
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("error is ", "" + error);
//            }
//        }) {
//
//            //This is for Headers If You Needed
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("Content-Type", "application/json");
//                params.put("token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJTdWJJRCI6IjEyMzQ1Njc4OTAiLCJFeHBpcmUiOjI2NzMyNDI5NDJ9.UvfkNy7uVvn0U8t3WjEUP-jEXk2GfGCkVvRg4TcWLJ0N");
//                params.put("X-Application-Name","1");
//                return params;
//            }
//
//            //Pass Your Parameters here
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("User", UserName);
//                params.put("Pass", PassWord);
//                return params;
//            }
//        };
//        RequestQueue queue = Volley.newRequestQueue(context);
//        queue.add(request);
        try {
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            String URL ="https://pp-api-raasgw.jio.com/v2/fetchdetails/";
//            JSONObject jsonBody = new JSONObject();
//            jsonBody.put("Title", "Android Volley Demo");
//            jsonBody.put("Author", "BNK");
//            final String requestBody = jsonBody.toString();
           final String requestBody = "{ \"buffer_type\": \"Request\", \"AppType\": 5, \"buffer\": { \"request_type\": 4, \"Body\": { \"ServiceInfo\": [ { \"DeviceType\": \"STB\", \"ServiceID\": 1, \"Subscriberdetails\": [ { \"SubscriberId\": \"1000051032\", \"Personalized\": { \"RecommType\": 1 } } ] } ] } } }";

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("VOLLEY Success", response);

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY Error", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json";
                }

                @Override
                public byte[] getBody() {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                      Map<String, String> params = new HashMap<String, String>();
                      params.put("Content-Type", "application/json");
                      params.put("token", "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJTdWJJRCI6IjEyMzQ1Njc4OTAiLCJFeHBpcmUiOjI2NzMyNDI5NDJ9.UvfkNy7uVvn0U8t3WjEUP-jEXk2GfGCkVvRg4TcWLJ0");
                      params.put("X-Application-Name","1");
                      return params;
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                        // can get more details such as response.headers
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            requestQueue.add(stringRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
