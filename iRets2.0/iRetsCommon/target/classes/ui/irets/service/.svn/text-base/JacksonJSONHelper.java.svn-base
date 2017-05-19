package ui.irets.service;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

public class JacksonJSONHelper {
	public static void serializeToJSON(Object obj,OutputStream out,HttpServletResponse response){
		ObjectMapper objMapper = new ObjectMapper();
		AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
		objMapper.getDeserializationConfig().setAnnotationIntrospector(introspector);
		objMapper.getSerializationConfig().setAnnotationIntrospector(introspector);
//		Gson gson = new Gson();
//		String lStr = gson.toJson(obj);
//		response.setContentLength(lStr.length());
//		OutputStreamWriter aOut = new OutputStreamWriter(out);
		try {
			objMapper.writeValue(out, obj);
//			aOut.write(lStr);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
