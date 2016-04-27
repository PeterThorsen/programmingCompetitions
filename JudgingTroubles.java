import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 
 * @author Peter Thorsen
 * @Date   Apr 15, 2016
 *
 * Problem URL: https://open.kattis.com/problems/judging
 */
public class JudgingTroubles {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String submissionsString = reader.readLine();
		int submissions = new Integer(submissionsString);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		
		for(int i = 0; i<submissions; i++) {
			String currentLine = reader.readLine();
			
			if(map.containsKey(currentLine)) {
				int temp = map.get(currentLine);
				temp++;
				map.put(currentLine, temp);
			}
			else {
				map.put(currentLine, 1);
			}
		}
		
		
		for(int i = 0; i<submissions; i++) {
			String currentLine = reader.readLine();
			
			if(map2.containsKey(currentLine)) {
				int temp = map2.get(currentLine);
				temp++;
				map2.put(currentLine, temp);
			}
			else {
				map2.put(currentLine, 1);
			}
		}
		int result = 0;
		for(String key : map.keySet()) {
			if(map2.containsKey(key)) {
				result += Math.min(map.get(key), map2.get(key));
			}
		}
		//System.out.println("correct: " + Math.min(correctDOM, correctKattis) +", wrong: " + Math.min(wrongDOM, wrongKattis) + ", time: " + Math.min(timeDOM, timeKattis));
		System.out.println(result);
		
	}

}
