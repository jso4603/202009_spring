package org.spring.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;


@Service
public class NaverLoginService {
	// �����ڵ尪 ��û
	public Map<String,String> getLoginUrl() throws UnsupportedEncodingException {
		String clientId = "WzjwRR2PM6wmnTqMnjkt";//���ø����̼� Ŭ���̾�Ʈ ���̵�";
	    // �ݹ� �ּ�
	    String redirectURI = URLEncoder.encode("http://localhost:8081/sample/login/callback", "UTF-8");
	    SecureRandom random = new SecureRandom();
	    String state = new BigInteger(130, random).toString(); // üũ ��
	    String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code"; // �����ڵ尪 ��û
	    apiURL += "&client_id=" + clientId;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&state=" + state;
	    
	    Map<String,String> resultMap = new HashMap<>();
	    resultMap.put("apiURL", apiURL);
	    resultMap.put("state", state);
	    
	    return resultMap;
	}
	
	// ����������ȸ
	public Map<String, String> getUserInfo(String code, String state) throws ParseException {
		String token = getToken(code,state); // ���̹� �α��� ���� ��ū;
        String header = "Bearer " + token; // Bearer ������ ���� �߰�

        String apiURL = "https://openapi.naver.com/v1/nid/me";

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Authorization", header);
        String responseBody = get(apiURL,requestHeaders);

        System.out.println(responseBody);
        
        // �Ľ� : ���̵�, �̸���, �̸�
        JSONObject object = (JSONObject)new JSONParser().parse(responseBody);
        object = (JSONObject) object.get("response");
        String id = (String) object.get("id");
        String email = (String) object.get("email");
        String name = (String) object.get("name");
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("id", id);
        resultMap.put("email", email);
        resultMap.put("name", name);
       
        return resultMap;
	}
	
	private static String get(String apiUrl, Map<String, String> requestHeaders){
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // ���� ȣ��
                return readBody(con.getInputStream());
            } else { // ���� �߻�
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API ��û�� ���� ����", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL�� �߸��Ǿ����ϴ�. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("������ �����߽��ϴ�. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API ������ �дµ� �����߽��ϴ�.", e);
        }
    }
	
	// ��ū��û
	public String getToken(String code, String state) {
		String clientId = "WzjwRR2PM6wmnTqMnjkt";//���ø����̼� Ŭ���̾�Ʈ ���̵�";
	    String clientSecret = "DUvw1gdi1F";//���ø����̼� Ŭ���̾�Ʈ ��ũ����";
	    //code = (String)request.getAttribute("code"); //���� �ڵ尪
	    //state = (String)request.getAttribute("state"); // ��ûpc���� ������ ��
	    String apiURL;
	    // ��� : ���̹��� ������ ��� ���� ��
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;
	    String access_token = "";
	    String refresh_token = "";
	    System.out.println("apiURL="+apiURL);
	    try {
	      URL url = new URL(apiURL);
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("GET");
	      int responseCode = con.getResponseCode();
	      BufferedReader br;
	      System.out.print("responseCode="+responseCode);
	      if(responseCode==200) { // ���� ȣ��
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      } else {  // ���� �߻�
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	      }
	      String inputLine;
	      StringBuffer res = new StringBuffer();
	      while ((inputLine = br.readLine()) != null) {
	        res.append(inputLine);
	      }
	      br.close();
	      if(responseCode==200) {
	        System.out.println(res.toString());
	        // ��ū �� �Ľ�
	        JSONObject object = (JSONObject)new JSONParser().parse(res.toString());
	        access_token = (String)object.get("access_token");
	        System.out.println(access_token);
	        
	      }
	    } catch (Exception e) {
	      System.out.println(e);
	    }
	    
	    return access_token;
	}
	
}