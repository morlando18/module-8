import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//12.13
/*
 * (Count characters, words, and lines in a file) Write a program that will count
the number of characters, words, and lines in a file. Words are separated by
whitespace characters. The file name should be passed as a command-line
argument, as shown in Figure 12.13.
*/
public class FileStatistics {
	public static void main(String[] args){

		try{
			// Variables
			String inputLine;
			File inputFile = new File("input.txt");
			File outputFile = new File("output.txt");
			
			Scanner input = new Scanner(inputFile);
			PrintWriter output = new PrintWriter(outputFile);
			int lineCount = 0;
			while(input.hasNextLine()){
				// read lines from input and print
				inputLine = input.nextLine();
				System.out.println(inputLine);
				
				// write lines to output
				output.println(inputLine);
				lineCount++;
			}
			System.out.println(lineCount + " lines" );
			// CLose the files
			input.close();
			output.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}
