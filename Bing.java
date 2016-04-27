import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 
 * @author Peter Thorsen
 * @Date   Apr 16, 2016
 *
 * Problem URL: https://open.kattis.com/problems/bing
 * 
 * Completed in programming competition
 */
public class Bing {
    public static void main(String[] args) throws IOException {
        new Bing();
    }

    private Bing() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();

        int n = Integer.parseInt(reader.readLine());
        for(int i = 0; i < n; i++) {
            String input = reader.readLine();
            SortedMap<String, Integer> tailMap = treeMap.tailMap(input);
            int result = 0;
            for(Map.Entry<String, Integer> a : tailMap.entrySet()) {
                if(a.getKey().startsWith(input)) {
                    result += a.getValue();
                } else {
                    break;
                }
            }
            if(treeMap.containsKey(input)) {
                treeMap.put(input, treeMap.get(input) + 1);
            } else {
                treeMap.put(input, 1);
            }
            System.out.println(result);
        }
    }
}
