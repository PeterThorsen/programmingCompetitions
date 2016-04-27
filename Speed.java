import java.util.Scanner;

/**
 * 
 * @author Peter Thorsen
 * @Date   Oct 11, 2015
 *
 * Problem URL: https://open.kattis.com/problems/speedlimit
 */
public class Speed {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfTuples = scanner.nextInt();
		boolean keepRunning;
		if(numberOfTuples == -1)
			keepRunning = false;
		else
			keepRunning = true;
		while(keepRunning) {
			int totalTime = 0;
			int toPrint = 0;
			for(int i = 0; i<numberOfTuples; i++) {
				int mph = scanner.nextInt();
				int timeDriven = scanner.nextInt();
				timeDriven = timeDriven-totalTime;
				totalTime = totalTime+timeDriven;
				toPrint = toPrint + timeDriven*mph;
			}
			System.out.println(toPrint + " miles");
			numberOfTuples = scanner.nextInt();
			if(numberOfTuples == -1)
				keepRunning = false;
		}
	}

}
