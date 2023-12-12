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
        int milkCount = gl.getMilk().size();
        int breadCount = gl.getBread().size();
        int cookieCount = gl.getCookies().size();
        int appleCount = gl.getApples().size();
        gl.countError();
        int errorCount = gl.getError();
        TreeMap<Double, Integer> milkPrices = countMilkPrices();
        TreeMap<Double, Integer> breadPrices = countBreadPrices();
        TreeMap<Double, Integer> cookiesPrices = countCookiesPrices();
        TreeMap<Double, Integer> applesPrices = countApplesPrices();
        StringBuilder sb = new StringBuilder();
        sb.append("name:    Milk 		 seen: ").append(milkCount).append(" times\n");
        sb.append("============= \t \t =============\n");
        for (Double key: milkPrices.keySet()){
            sb.append("Price: \t ").append(key).append("		 seen: ").append(milkPrices.get(key)).append(" times\n");
            sb.append("-------------\t\t -------------\n");
        }
        sb.append("\n");
        sb.append("name:   Bread		 seen: ").append(breadCount).append(" times\n");
        sb.append("============= \t \t =============\n");
        for (Double key: breadPrices.keySet()){
            sb.append("Price: \t ").append(key).append("		 seen: ").append(breadPrices.get(key)).append(" times\n");
            sb.append("-------------\t\t -------------\n");
        }
        sb.append("\n");
        sb.append("name: Cookies        seen: ").append(cookieCount).append(" times\n");
        sb.append("============= \t \t =============\n");
        for (Double key: cookiesPrices.keySet()){
            sb.append("Price: \t ").append(key).append("		 seen: ").append(cookiesPrices.get(key)).append(" times\n");
            sb.append("-------------\t\t -------------\n");
        }
        sb.append("\n");
        sb.append("name:  Apples		 seen: ").append(appleCount).append(" times\n");
        sb.append("============= \t \t =============\n");
        for (Double key: applesPrices.keySet()){
            sb.append("Price: \t ").append(key).append("		 seen: ").append(applesPrices.get(key)).append(" times\n");
            sb.append("-------------\t\t -------------\n");
        }
        sb.append("\n");
        sb.append("Errors         \t \t seen: ").append(errorCount).append(" times");
        return sb.toString();
    }

    public static TreeMap<Double, Integer> countMilkPrices(){
        ArrayList<Double> prices = new ArrayList<>();
        for (GroceryItem item : gl.getMilk()){
            if (item.getPrice().isEmpty()){
                continue;
            }
            else {
                prices.add(Double.valueOf(item.getPrice()));
            }
        }
        HashSet<Double> difPrice = new HashSet<>(prices);
        TreeMap<Double, Integer> allPrices = new TreeMap<>(Comparator.reverseOrder());
        for (Double price: difPrice){
            allPrices.put(price, 0);
        }
        for (Double key: allPrices.keySet()){
            for (Double price: prices){
                if(key.equals(price)){
                    int count = allPrices.get(key);
                    allPrices.put(key, count + 1);
                }
            }
        }

        return allPrices;
    }

    public static TreeMap<Double, Integer> countBreadPrices() {
        ArrayList<Double> prices = new ArrayList<>();
        for (GroceryItem item : gl.getBread()) {
            prices.add(Double.valueOf(item.getPrice()));
        }
        HashSet<Double> difPrice = new HashSet<>(prices);
        TreeMap<Double, Integer> allPrices = new TreeMap<>(Comparator.reverseOrder());
        for (Double price : difPrice) {
            allPrices.put(price, 0);
        }
        for (Double key : allPrices.keySet()) {
            for (Double price : prices) {
                if (key.equals(price)) {
                    int count = allPrices.get(key);
                    allPrices.put(key, count + 1);
                }
            }
        }

        return allPrices;
    }

    public static TreeMap<Double, Integer> countCookiesPrices() {
        ArrayList<Double> prices = new ArrayList<>();
        for (GroceryItem item : gl.getCookies()) {
            prices.add(Double.valueOf(item.getPrice()));
        }
        HashSet<Double> difPrice = new HashSet<>(prices);
        TreeMap<Double, Integer> allPrices = new TreeMap<>(Comparator.reverseOrder());
        for (Double price : difPrice) {
            allPrices.put(price, 0);
        }
        for (Double key : allPrices.keySet()) {
            for (Double price : prices) {
                if (key.equals(price)) {
                    int count = allPrices.get(key);
                    allPrices.put(key, count + 1);
                }
            }
        }

        return allPrices;
    }

    public static TreeMap<Double, Integer> countApplesPrices() {
        ArrayList<Double> prices = new ArrayList<>();
        for (GroceryItem item : gl.getApples()) {
            prices.add(Double.valueOf(item.getPrice()));
        }
        HashSet<Double> difPrice = new HashSet<>(prices);
        TreeMap<Double, Integer> allPrices = new TreeMap<>(Comparator.reverseOrder());
        for (Double price : difPrice) {
            allPrices.put(price, 0);
        }
        for (Double key : allPrices.keySet()) {
            for (Double price : prices) {
                if (key.equals(price)) {
                    int count = allPrices.get(key);
                    allPrices.put(key, count + 1);
                }
            }
        }

        return allPrices;
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
