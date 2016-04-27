import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author Peter Thorsen
 * @Date   Apr 16, 2016
 *
 * Problem URL: https://open.kattis.com/problems/temperature
 * 
 * Completed in programming competition
 */
public class Temperature {
    public static void main(String[] args) throws IOException {
        new Temperature();
    }

    private Temperature() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        double x = Integer.parseInt(input.split(" ")[0]);
        double y = Integer.parseInt(input.split(" ")[1]);
        if(x == 0 && y == 1) {
            System.out.println("ALL GOOD");
        } else if(y == 1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(x / (-y + 1.0));
        }

    }
}
