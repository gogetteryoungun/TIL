import java.util.*;
import java.io.*;


public class Test {
	public static void main(String[] args) {
	
	Stock test = new Stock();
	
    String inputfile = "/Users/yoonnyung/Documents/practice/Stock/src/input2.txt";
    Scanner inFile = null;
    try 
    {
        inFile = new Scanner(new File(inputfile));
    } 
    catch (FileNotFoundException e) 
    {
        e.printStackTrace();
    }
    int N=0;
    while(inFile.hasNextLine())
    {
        test.storeInput(inFile.nextLine());
        N++;
    }
    test.createStart(30);
    test.createEnd();
    test.createLow();
    test.createHigh();
    test.createOpen();
    test.createClose();
    test.createVolume();
    test.createAve(N);
    test.printInput(N);
    
    
	}
}
