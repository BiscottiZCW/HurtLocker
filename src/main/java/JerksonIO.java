import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
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
            // This could be optimized, perhaps abstracted
            if (gi.errorFound()){
                gl.incrementError();
            }
            if (gi.getName().isEmpty()){
                gl.incrementError();
                continue;
            }
            pattern = Pattern.compile("[mM]..[kK]");
            matcher = pattern.matcher(gi.getName());
            if (matcher.matches()){
                gl.addToMilk(gi);
                continue;
            }
            pattern = Pattern.compile("[aA]....[sS]");
            matcher = pattern.matcher(gi.getName());
            if (matcher.matches()){
                gl.addToApples(gi);
                continue;
            }
            pattern = Pattern.compile("[bB]...[dD]");
            matcher = pattern.matcher(gi.getName());
            if (matcher.matches()){
                gl.addToBread(gi);
                continue;
            }
            pattern = Pattern.compile("[cC].....[sS]");
            matcher = pattern.matcher(gi.getName());
            if (matcher.matches()){
                gl.addToCookies(gi);
            }
        }
    }

    public static String createFormatString() {
        int errorCount = gl.getError();
        gl.countAllPrices();
        TreeMap<Double, Integer> milkPrices = gl.getMilkPrices();
        TreeMap<Double, Integer> breadPrices = gl.getBreadPrices();
        TreeMap<Double, Integer> cookiesPrices = gl.getCookiesPrices();
        TreeMap<Double, Integer> applesPrices = gl.getApplesPrices();

        StringBuilder sb = new StringBuilder();
        int i = 0;
        sb.append("name:    Milk 		 seen: ").append(gl.getMilkPriceCount()).append(" times\n");
        sb.append("============= \t \t =============\n");
        for (Double key: milkPrices.keySet()){
            sb.append("Price: \t ").append(key).append("		 seen: ").append(milkPrices.get(key)).append(" times\n");
            if (i == 0){
                sb.append("-------------\t\t -------------\n");
            }
            i++;
        }
        sb.append("\n");
        i = 0;
        sb.append("name:   Bread		 seen: ").append(gl.getBreadPriceCount()).append(" times\n");
        sb.append("============= \t \t =============\n");
        for (Double key: breadPrices.keySet()){
            sb.append("Price: \t ").append(key).append("		 seen: ").append(breadPrices.get(key)).append(" times\n");
            if (i == 0){
                sb.append("-------------\t\t -------------\n");
            }
            i++;
        }
        sb.append("\n");
        i = 0;
        sb.append("name: Cookies        seen: ").append(gl.getCookiePriceCount()).append(" times\n");
        sb.append("============= \t \t =============\n");
        for (Double key: cookiesPrices.keySet()){
            sb.append("Price: \t ").append(key).append("		 seen: ").append(cookiesPrices.get(key)).append(" times\n");
            if (i == 0){
                sb.append("-------------\t\t -------------\n");
            }
            i++;
        }
        sb.append("\n");
        i = 0;
        sb.append("name:  Apples		 seen: ").append(gl.getApplePriceCount()).append(" times\n");
        sb.append("============= \t \t =============\n");
        for (Double key: applesPrices.keySet()){
            sb.append("Price: \t ").append(key).append("		 seen: ").append(applesPrices.get(key)).append(" times\n");
            if (i == 0){
                sb.append("-------------\t\t -------------\n");
            }
            i++;
        }
        sb.append("\n");
        sb.append("Errors         \t \t seen: ").append(errorCount).append(" times");
        return sb.toString();
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
        String results = JerksonIO.createFormatString();
        JerksonIO.exportTxt(results);
    }
    //tevin was here.
}
