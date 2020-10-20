import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class KeyManager {
	private static KeyManager instance = null;
	private String key = "";
	
	public static KeyManager getInstance() {
		if (instance == null) {
			instance = new KeyManager();
		}
		return instance;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public synchronized String createKey(int problem) {
		String key = null;
		String response = Connection.getInstance().start(problem);
	
		if (response.equals("400")) {
			System.out.println("400:: 범위 값 잘못됨");
		} else if (response.equals("401")) {
			System.out.println("401:: X-Auth-Token Header가 잘못됨");
		} else if (response.equals("500")) {
			System.out.println("500:: 서버 에러, 문의 필요");
		} else {
			saveKeyFile(response/* key */);
			key = response;
			response = "200";
		}
		this.key = key;
		return response;
	}

	private void saveKeyFile(String key) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("./res/key")));
			bw.write(key);
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
