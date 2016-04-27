import java.util.Scanner;

/**
 * 
 * @author Peter Thorsen
 * @Date   Oct 14, 2015
 *
 * Problem URL: https://open.kattis.com/problems/pet
 */
public class Pet {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int winner = 0;
		int maxPoints = 0;
		for(int i = 0; i<5; i++) {
			int pts1 = scanner.nextInt();
			int pts2 = scanner.nextInt();
			int pts3 = scanner.nextInt();
			int pts4 = scanner.nextInt();
			int currentPoints = pts1+pts2+pts3+pts4;
			if(currentPoints>maxPoints) {
				maxPoints = currentPoints;
				winner = i+1;
			}
		}
		System.out.println(winner + " " + maxPoints);
	}

}
