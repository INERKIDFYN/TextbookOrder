package cn.zzu.JsonReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

public class JsonReader {

	public JSONObject receivePost(HttpServletRequest request) throws IOException, UnsupportedEncodingException {
		 
		if(request.getMethod().equals("get")){
			return null;
		}
		// 读取请求内容
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream(),"utf-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		br.close();
		//将json字符串转换为json对象
		JSONObject json=JSONObject.fromObject(sb.toString());
		return json;
	}
}
