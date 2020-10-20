import java.util.ArrayList;

import org.json.JSONArray;

public class Main {

	static JSONParser parser = new JSONParser();
	static int[][] map;
	static int getId1 = 0;
	static int getId2 = 0;
	static int putId1 = 0;
	static int putId2 = 0;
	public static void main(String[] args) {
		int problem = 1; 
		String response = start(problem);
		System.out.println(response);
		if(response.equals("200")) {
			if(problem == 1) {
				map = new int[5][5];
				for(int i = 0 ; i < 720 ; i++) {
					ArrayList<Location> locationList = locations();
					setMap(locationList,5);
					ArrayList<Truck> truckList = trucks();
					ArrayList<Command> commandList = new ArrayList();
					for(int j = 0 ; j < truckList.size(); j++) {
						commandList.add(getCommand(truckList.get(j)));
					}
					simulate(commandList);
				}
			}
			else {
				map = new int[60][60];
				for(int i = 0 ; i < 240; i++) {
					getId1 = 3595;
					putId1 = 3386;
					putId2 = 3037;
					ArrayList<Location> locationList = locations();
					setMap(locationList,60);
					ArrayList<Truck> truckList = trucks();
					ArrayList<Command> commandList = new ArrayList();
					for(int j = 0 ; j < truckList.size()-2; j++) {
						commandList.add(getCommand2(truckList.get(j)));
					}
					commandList.add(getCommand3(truckList.get(8),getId1,putId1));
					commandList.add(getCommand3(truckList.get(9),getId1,putId2));
					simulate(commandList);
				}
				for(int i = 240; i < 480; i++) {
					getId1 = 725;
					getId2 = 628;
					putId1 = 2635;
					ArrayList<Location> locationList = locations();
					setMap(locationList,60);
					ArrayList<Truck> truckList = trucks();
					ArrayList<Command> commandList = new ArrayList();
					for(int j = 0 ; j < truckList.size()-2; j++) {
						commandList.add(getCommand2(truckList.get(j)));
					}
					commandList.add(getCommand3(truckList.get(8),getId1,putId1));
					commandList.add(getCommand3(truckList.get(9),getId2,putId1));
					simulate(commandList);
				}
				for(int i = 480; i < 720; i++) {
					getId1 = 3515;
					getId2 = 969;
					putId1 = 2465;
					ArrayList<Location> locationList = locations();
					setMap(locationList,60);
					ArrayList<Truck> truckList = trucks();
					ArrayList<Command> commandList = new ArrayList();
					for(int j = 0 ; j < truckList.size()-2; j++) {
						commandList.add(getCommand2(truckList.get(j)));
					}
					commandList.add(getCommand3(truckList.get(8),getId1,putId1));
					commandList.add(getCommand3(truckList.get(9),getId2,putId1));
					simulate(commandList);
				}
			}
		}
	}
	private static void setMap(ArrayList<Location> locationList,int size) {
		for(int i = 0 ; i < locationList.size(); i++) {
			Location location = locationList.get(i);
			int id = location.getId();
			int bikes = location.getLocatedBikesCount();
			int x = idToLocation(id,size)[0];
			int y = idToLocation(id,size)[1];
			map[x][y] = bikes;
		}
	}
	private static ArrayList<Location> locations() {
		ArrayList<Location> locationList = new ArrayList(); 
		locationList = parser.getLocationListFromLocations(Connection.getInstance().locations());
		return locationList;
	}
	private static ArrayList<Truck> trucks() {
		ArrayList<Truck> truckList = new ArrayList();
		truckList = parser.getTruckListFromTrucks(Connection.getInstance().trucks());
		return truckList;
		
	}
	private static void simulate(ArrayList<Command> commandList) {
		JSONArray commandsJSON = parser.getCommandsJSONArray(commandList);
		System.out.println(Connection.getInstance().simulate(commandsJSON).get("failed_requests_count"));
	}
	private static String start(int problem) {
		System.out.println(">>>> api.start()");
		String response = KeyManager.getInstance().createKey(problem);
		System.out.println("Key : " + KeyManager.getInstance().getKey());
		return response;
	}
	
	private static int[] idToLocation(int id,int size) {
		int[] result = new int[2];
		result[0] = id % size;
		result[1] = id / size;
		return result;
	}
	
	private static Command getCommand(Truck truck) {
		Command command = new Command();
		ArrayList<Integer> commandList = new ArrayList();
		int id = truck.getId();
		int locationId = truck.getLocationId();
		int bikes = truck.getLoadedBikesCount();
		int x = 0;
		int y = 0;
		int minx = 0;
		int miny = 0;
		int maxx = 0;
		int maxy = 0;
		int max = 0;
		int min = 1000;
		int truckx = idToLocation(locationId,5)[0];
		int trucky = idToLocation(locationId,5)[1];
		command.setTruckId(id);
		if(id == 0) {
			x = 0;
			y = 0;
		}else if(id == 1) {
			x = 2;
			y = 0;
		}else if(id == 2) {
			x = 0;
			y = 2;
		}else if(id == 3) {
			x = 2;
			y = 2;
		}else if(id == 4) {
			x = 1;
			y = 1;
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0 ; j < 3; j++) {
				if(map[x+i][y+i] > max) {
					max = map[x+i][y+j];
					maxx = x+i;
					maxy = y+j;
				}
				if(map[x+i][y+i] < min) {
					min = map[x+i][y+i];
					minx = x+i;
					miny = y+j;
				}
			}
		}
		if(bikes < 20){
			moveTo(commandList,truckx,trucky,maxx,maxy);
			commandList.add(5);
			moveTo(commandList,maxx,maxy,minx,miny);
			commandList.add(6);
		}
		else {
			moveTo(commandList,maxx,maxy,minx,miny);
			commandList.add(6);
		}
		for(int i = 0; i < commandList.size(); i++) {
			if(i >= 10) {
				break;
			}
			else {
				command.getCommand()[i] = commandList.get(i);
			}
		}
		return command;
	}
	
	private static Command getCommand2(Truck truck) {
		Command command = new Command();
		ArrayList<Integer> commandList = new ArrayList();
		int id = truck.getId();
		int locationId = truck.getLocationId();
		int bikes = truck.getLoadedBikesCount();
		int x = 0;
		int y = 0;
		int minx = 0;
		int miny = 0;
		int maxx = 0;
		int maxy = 0;
		int max = 0;
		int min = 1000;
		int truckx = idToLocation(locationId,60)[0];
		int trucky = idToLocation(locationId,60)[1];
		command.setTruckId(id);
		if(id == 0) {
			x = 0;
			y = 0;
		}else if(id == 1) {
			x = 0;
			y = 15;
		}else if(id == 2) {
			x = 0;
			y = 30;
		}else if(id == 3) {
			x = 0;
			y = 45;
		}else if(id == 4) {
			x = 30;
			y = 0;
		}else if(id == 5) {
			x = 30;
			y = 15;
		}else if(id == 6) {
			x = 30;
			y = 30;
		}else if(id == 7) {
			x = 30;
			y = 45;
		}
		for(int i = 0; i < 30; i++) {
			for(int j = 0 ; j < 15; j++) {
				if(map[x+i][y+j] > max) {
					max = map[x+i][y+j];
					maxx = x+i;
					maxy = y+j;
				}
				if(map[x+i][y+j] < min) {
					min = map[x+i][y+j];
					minx = x+i;
					miny = y+j;
				}
			}
		}
		if(bikes < 20){
			moveTo(commandList,truckx,trucky,maxx,maxy);
			commandList.add(5);
			moveTo(commandList,maxx,maxy,minx,miny);
			commandList.add(6);
		}
		else {
			moveTo(commandList,maxx,maxy,minx,miny);
			commandList.add(6);
		}
		for(int i = 0; i < commandList.size(); i++) {
			if(i >= 10) {
				break;
			}
			else {
				command.getCommand()[i] = commandList.get(i);
			}
		}
		return command;
	}
	
	private static Command getCommand3(Truck truck, int getId, int putId) {
		Command command = new Command();
		ArrayList<Integer> commandList = new ArrayList();
		int id = truck.getId();
		int locationId = truck.getLocationId();
		int bikes = truck.getLoadedBikesCount();
		int truckx = idToLocation(locationId,60)[0];
		int trucky = idToLocation(locationId,60)[1];
		int startx = idToLocation(putId,60)[0];
		int starty = idToLocation(putId,60)[1];
		int endx = idToLocation(getId,60)[0];
		int endy = idToLocation(getId,60)[1];
		command.setTruckId(id);
		if(bikes !=0 ) {
				moveTo(commandList,truckx,trucky,endx,endy);
				for(int i = 0 ; i < bikes; i++) {
					commandList.add(6);
				}
				moveTo(commandList,truckx,trucky,startx,starty);
		}
		else {
			moveTo(commandList,truckx,trucky,startx,starty);
			for(int i = 0; i < map[startx][starty]; i++) {
				commandList.add(5);
			}
			moveTo(commandList,truckx,trucky,endx,endy);
		}
		
		return command;
	}
	
	private static void moveTo(ArrayList<Integer> commandList,int startx,int starty,int endx,int endy) {
		for(int i = 0; i < startx-endx; i++) {
			commandList.add(1);
		}
		for(int i = 0; i < starty-endy; i++) {
			commandList.add(2);
		}
		for(int i = 0; i < endx-startx; i++) {
			commandList.add(3);
		}
		for(int i = 0; i < endy-starty; i++) {
			commandList.add(4);
		}
	}
}
