package kr.co.moneybnb2;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class APIProc extends AsyncTask<String, Integer, String> {
	
	Context mContext;
	String which = "";
	
	public APIProc(Context con){
		mContext = con;
	}
    @Override
    protected String doInBackground(String... params) {
    	
    	 HttpClient httpClient = new DefaultHttpClient();
    	 HttpPost httpPost = new HttpPost("http://moneybnb.kr/api.php");
		HttpContext localContext = new BasicHttpContext();
    	 List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();

		String result = "";
    	 if(params[0].equals("register")){

        	 
    	 }else if(params[0].equals("login")){
    		 
        	 nameValuePair.add(new BasicNameValuePair("type", "login"));
        	 nameValuePair.add(new BasicNameValuePair("email", params[1]));
        	 nameValuePair.add(new BasicNameValuePair("pass", params[2]));
        	 

    	 }else if(params[0].equals("myinfo1")){

			 nameValuePair.add(new BasicNameValuePair("type", "myinfo1"));
			 nameValuePair.add(new BasicNameValuePair("uid", params[1]));



		 }else{
    		 
    	 }



			try {
				httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair, HTTP.UTF_8));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}

			try {
				HttpResponse response = httpClient.execute(httpPost);
				InputStream ips = response.getEntity().getContent();
				BufferedReader buf = new BufferedReader(new InputStreamReader(ips, "UTF-8"));
				if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
					throw new Exception(response.getStatusLine().getReasonPhrase());
				}
				StringBuilder sb = new StringBuilder();
				String s;
				while (true) {
					s = buf.readLine();
					if (s == null || s.length() == 0)
						break;

					sb.append(s);

				}
				buf.close();
				ips.close();

				Log.v("Http Post Response:", sb.toString());
				result = sb.toString();

			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    
    	
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
    }

    @Override
    protected void onPreExecute() {
    	
    }
    @Override
    protected void onProgressUpdate(Integer... values) {

    }
}