package com.riis.deltacrack;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import android.os.Build;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.widget.TextView;
import android.app.Activity;
import android.content.Context;

public class MainActivity extends Activity {
	private String android_id;
	private String device_id;
	TelephonyManager mTelephonyMgr;
	
	// TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);	
	// private String device_id = telephonyManager.getDeviceId();
	// private String android_id = "518740c036f33cbd";	
	// private String device_id = "32C25B054972878E"; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView helloworld = (TextView) this.findViewById(R.id.helloworld);
        
    	android_id = Secure.getString(this.getContentResolver(), Secure.ANDROID_ID); 

    	// mTelephonyMgr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
       	// device_id = mTelephonyMgr.getDeviceId();
    	device_id = ((TelephonyManager)getSystemService("phone")).getDeviceId();
    	
 
    	 	
        try {
    	 	// String result = generateSHA1Key("IL0veC0ffee", "CoffeeIsForClosers");
        	String str2 = getUDID();
        	String result = generateSHA1Key(android_id, device_id); //str2?
	        helloworld.setText(result);
        	//helloworld.setText(device_id);
	        Log.i("mytag",result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public String getUDID()
    {
	      String str1 = Build.BOARD + Build.BRAND + Build.CPU_ABI + Build.DEVICE + Build.DISPLAY + Build.FINGERPRINT + Build.HOST + Build.ID + Build.MANUFACTURER + Build.MODEL + Build.PRODUCT + Build.TAGS + Build.TYPE + Build.USER;
      return md5(str1 + device_id + android_id);
    }

    public String md5(String paramString)
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        localMessageDigest.update(paramString.getBytes());
        byte[] arrayOfByte = localMessageDigest.digest();
        StringBuffer localStringBuffer = new StringBuffer();
        for (int i = 0; ; i++)
        {
          if (i >= arrayOfByte.length)
            return localStringBuffer.toString();
          localStringBuffer.append(Integer.toHexString(0xFF & arrayOfByte[i]));
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        localNoSuchAlgorithmException.printStackTrace();
      }
      return "";
    }
    
	public static final String generateSHA1Key(String paramString1, String paramString2) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException
		  {
		    SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString2.getBytes("UTF-8"), "HmacSHA1");
		    Mac localMac = Mac.getInstance("HmacSHA1");
		    localMac.init(localSecretKeySpec);
		    return new String(Base64.encode(localMac.doFinal(paramString1.getBytes("UTF-8")), 0));
		  }    

    
}
