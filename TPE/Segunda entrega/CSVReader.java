package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	
	private boolean firstLine = true;
    
	public List<String[]> readFile(String fileName) {
		List<String[]> result = new ArrayList<String[]>();
        String line = "";
        String cvsSplitBy = ",";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
            	IterationCounter.add();
            	if (!this.firstLine){
            		String[] items = line.split(cvsSplitBy);
                    result.add(items);
            	}
                this.firstLine = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
