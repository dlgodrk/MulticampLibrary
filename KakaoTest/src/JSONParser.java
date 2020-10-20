import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONParser {
	public ArrayList<Location> getLocationListFromLocations(JSONObject responseJSON){
		ArrayList<Location> locationList = new ArrayList();
		JSONArray jsonArray = responseJSON.getJSONArray("locations");
		for(int i = 0 ; i < jsonArray.length(); i++) {
			JSONObject json = jsonArray.getJSONObject(i);
			Location location = new Location();
			location.setId(json.getInt("id"));
			location.setLocatedBikesCount(json.getInt("located_bikes_count"));
			locationList.add(location);
		}
		
		return locationList;
	}
	
	public ArrayList<Truck> getTruckListFromTrucks(JSONObject responseJSON){
		ArrayList<Truck> truckList = new ArrayList();
		JSONArray jsonArray = responseJSON.getJSONArray("trucks");
		for(int i = 0 ; i < jsonArray.length(); i++) {
			JSONObject json = jsonArray.getJSONObject(i);
			Truck truck = new Truck();
			truck.setId(json.getInt("id"));
			truck.setLocationId(json.getInt("location_id"));
			truck.setLoadedBikesCount(json.getInt("loaded_bikes_count"));
			truckList.add(truck);
		}
		
		return truckList;
	}
	
	public JSONArray getCommandsJSONArray(ArrayList<Command> commandList) {
		JSONArray commandArray = new JSONArray();
		for (Command command : commandList) {
			commandArray.put(command.getJsonCommandData());
		}
		
		return commandArray;
	}
}
