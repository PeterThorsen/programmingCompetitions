import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * 
 * @author Peter Thorsen
 * @Date   Apr 19, 2016
 *
 * Problem URL: https://open.kattis.com/problems/akcija
 */
public class Akcija {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String noOfBooksString = reader.readLine();
		int noOfBooks = new Integer(noOfBooksString);
		TreeMap<Integer, Integer> allBooks = new TreeMap<Integer, Integer>();
		for(int i = 0; i<noOfBooks; i++) {
			int currentBook = new Integer(reader.readLine());

			if(allBooks.containsKey(currentBook)) {
				int booksOfCurrentPrice = allBooks.get(currentBook);
				booksOfCurrentPrice++;
				allBooks.put(currentBook, booksOfCurrentPrice);
			}
			else {
				allBooks.put(currentBook, 1);
			}
		}
		reader.close();

		int minimumCost = 0;
		int i = 1;

		for(int key : allBooks.descendingMap().keySet()) {
			int value = allBooks.get(key);
			for(int eachInValue = 0; eachInValue<value; eachInValue++) {
				if(i % 3 != 0) {
					minimumCost += key;
				}
				i++;
			}
		}
		System.out.println(minimumCost);
	}

}
