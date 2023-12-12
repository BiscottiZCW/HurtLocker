import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.PrintWriter;

public class JerksonIO {

    GroceryList gl = new GroceryList();

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void extractValues(String rawData){
//        String[] array = rawData.split()
    }

    public static String createFormatString() {
        return null;
    }

    public static void exportTxt(String output){
        try{
            PrintWriter fileOut = new PrintWriter("results.txt");
            fileOut.println(output);
            fileOut.close();
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
    }

    public static void main(String[] args) throws Exception{
        String output = (new JerksonIO()).readRawDataToString();
        JerksonIO.extractValues(output);
        JerksonIO.createFormatString();
        JerksonIO.exportTxt(output);
    }
    //tevin was here.
}
