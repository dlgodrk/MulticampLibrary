import org.json.JSONException;
import org.json.JSONObject;

public class Command {
	private int truckId;
	private int[] command = new int[10];
	
	public int getTruckId() {
		return truckId;
	}
	public void setTruckId(int truckId) {
		this.truckId = truckId;
	}
	public int[] getCommand() {
		return command;
	}
	public void setCommand(int[] command) {
		this.command = command;
	}
	
	public JSONObject getJsonCommandData() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("truck_id", truckId);
			jsonObject.put("command", command);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonObject;
	}
}
