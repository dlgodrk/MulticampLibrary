import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.w3c.dom.Node;

public class test {
	private final String USER_AGENT ="Mozilla/5.0";
	public static void main(String[] args) {
		test http = new test();
		try {
			http.sendGet();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void sendGet() throws Exception{
		
		String url = "http://openapi-lib.sen.go.kr/openapi/service/lib/openApi?serviceKey=zG4CCEon2sxlG9ZvVNNg0rZ89bg2pTgcY%2FUZe7OLvhJn4zVZ1aC3QdDE6UulqhGWAyR04hsF%2FqrYvqPi%2FhO%2FJw%3D%3D&title=%EB%8F%84%EB%91%91&manageCd=MB&numOfRows=5&pageNo=2&";
		Node seoul = null;
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection)obj.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		
		while((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
			response.append(inputLine);
		}
		
		in.close();
	}
}
