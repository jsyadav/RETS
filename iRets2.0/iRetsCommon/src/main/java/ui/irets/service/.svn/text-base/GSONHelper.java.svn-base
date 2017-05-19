package ui.irets.service;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class GSONHelper {
	public static void serializeToJSON(Object obj,OutputStream out,HttpServletResponse response){
		Gson gson = new Gson();
		String lStr = gson.toJson(obj);
		response.setContentLength(lStr.length());
		OutputStreamWriter aOut = new OutputStreamWriter(out);
		try {
			aOut.write(lStr);
			aOut.flush();
			aOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
