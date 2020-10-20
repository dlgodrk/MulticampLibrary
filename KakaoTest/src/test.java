import org.json.JSONArray;
import org.json.JSONObject;

public class test {

	public static void main(String[] args) {
		int[] get1 = new int[3600];
		int[] put1 = new int[3600];
		int[] get2 = new int[3600];
		int[] put2 = new int[3600];
		int[] get3 = new int[3600];
		int[] put3 = new int[3600];
		int getIndex1 = 0;
		int getIndex2 = 0;
		int getIndex3 = 0;
		int putIndex1 = 0;
		int putIndex2 = 0;
		int putIndex3 = 0;
		int max1 = 0;
		int max2 = 0;
		int max3 = 0;
		int max4 = 0;
		int max5 = 0;
		int max6 = 0;
		JSONObject json = Connection.getInstance().getSample("https://grepp-cloudfront.s3.ap-northeast-2.amazonaws.com/programmers_imgs/competition-imgs/2021kakao/problem2_day-3.json");
		for(int i = 0 ; i < 240 ; i++) {
			if(json.has(Integer.toString(i))) {
				JSONArray check1 = json.getJSONArray(Integer.toString(i));
				for(int j = 0 ; j < check1.length(); j++) {
					JSONArray check2 = check1.getJSONArray(j);
					int start = (int)check2.get(0);
					int end = (int)check2.get(1);
					get1[start]++;
					put1[end]++;
				}
			}
		}
		for(int i = 240 ; i < 480 ; i++) {
			if(json.has(Integer.toString(i))) {
				JSONArray check1 = json.getJSONArray(Integer.toString(i));
				for(int j = 0 ; j < check1.length(); j++) {
					JSONArray check2 = check1.getJSONArray(j);
					int start = (int)check2.get(0);
					int end = (int)check2.get(1);
					get2[start]++;
					put2[end]++;
				}
			}
		}
		for(int i = 480 ; i < 720 ; i++) {
			if(json.has(Integer.toString(i))) {
				JSONArray check1 = json.getJSONArray(Integer.toString(i));
				for(int j = 0 ; j < check1.length(); j++) {
					JSONArray check2 = check1.getJSONArray(j);
					int start = (int)check2.get(0);
					int end = (int)check2.get(1);
					get3[start]++;
					put3[end]++;
				}
			}
		}
		for(int i = 0; i < 3600; i++) {
			if(get1[i]-put1[i] > max1) {
				getIndex1 = i;
				max1 = get1[i]-put1[i];
			}
			if(get2[i]-put2[i] > max2) {
				getIndex2 = i;
				max2 = get2[i]-put2[i];
			}
			if(get3[i]-put3[i] > max3) {
				getIndex3 = i;
				max3 = get3[i]-put3[i];
			}
			if(put1[i]-get1[i] > max4) {
				putIndex1 = i;
				max4 = put1[i]-get1[i];
			}
			if(put2[i]-get2[i] > max5) {
				putIndex2 = i;
				max5 = put2[i]-get2[i];
			}
			if(put3[i]-get3[i] > max6) {
				putIndex3 = i;
				max6 = put3[i]-get3[i];
			}
		}
		
		System.out.println(getIndex1+" "+putIndex1+" "+max1+" "+max4);
		System.out.println(getIndex2+" "+putIndex2+" "+max2+" "+max5);
		System.out.println(getIndex3+" "+putIndex3+" "+max3+" "+max6);
	}

}
