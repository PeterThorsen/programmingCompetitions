import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/**
 * 
 * @author Peter Thorsen
 * @Date   Apr 19, 2016
 *
 * Problem URL: https://open.kattis.com/problems/bookingaroom
 */
public class BookingARoom {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String roomsAndRoomsBooked = reader.readLine();
		int noOfRooms = new Integer(roomsAndRoomsBooked.split(" ")[0]);
		int roomsBooked = new Integer(roomsAndRoomsBooked.split(" ")[1]);
		
		TreeSet<Integer> roomsBookedSet = new TreeSet<Integer>();
		for(int i=0; i<roomsBooked; i++) {
			int currentRoom = new Integer(reader.readLine());
			roomsBookedSet.add(currentRoom);
		}
		for(int i=0; i<noOfRooms; i++) {
			if(!roomsBookedSet.contains(i+1)) {
				System.out.println(i+1);
				return;
			}
		}
		System.out.println("too late");
		
	}

}
