import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JerksonIO {

    static GroceryList gl = new GroceryList();
    static Pattern pattern;
    static Matcher matcher;

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void extractValues(String rawData){
        String[] array = rawData.split("##");
        for (String item: array){
            GroceryItem gi = new GroceryItem(item);
            // Add item to whichever GroceryList list it belongs in
            pattern = Pattern.compile("[mM]..[kK]");
            matcher = pattern.matcher(gi.getName());
            if (matcher.matches()){
                gl.getMilk().add(gi);
            }
            pattern = Pattern.compile("[aA]....[sS]");
            matcher = pattern.matcher(gi.getName());
            if (matcher.matches()){
                gl.getApples().add(gi);
            }
            pattern = Pattern.compile("[bB]...[dD]");
            matcher = pattern.matcher(gi.getName());
            if (matcher.matches()){
                gl.getBread().add(gi);
            }
            pattern = Pattern.compile("[cC].....[sS]");
            matcher = pattern.matcher(gi.getName());
            if (matcher.matches()){
                gl.getCookies().add(gi);
            }
            pattern = Pattern.compile("\\s");
            matcher = pattern.matcher(gi.getName());
            if (matcher.matches()){
                int errors = gl.getError();
                gl.setError(errors + 1);
            }
        }
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
