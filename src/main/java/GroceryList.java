
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeMap;

public class GroceryList extends ArrayList<ArrayList<GroceryItem>> {

    ArrayList<GroceryItem> Milk;
    ArrayList<GroceryItem> Bread;
    ArrayList<GroceryItem> Cookies;
    ArrayList<GroceryItem> Apples;
    int Error;

    TreeMap<Double, Integer> milkPrices;
    int milkPriceCount = 0;
    TreeMap<Double, Integer> breadPrices;
    int breadPriceCount = 0;
    TreeMap<Double, Integer> cookiesPrices;
    int cookiePriceCount = 0;
    TreeMap<Double, Integer> applesPrices;
    int applePriceCount = 0;

    public GroceryList() {
        this.Milk = new ArrayList<>();
        this.Bread = new ArrayList<>();
        this.Cookies = new ArrayList<>();
        this.Apples = new ArrayList<>();
        this.Error = 0;
    }


    public ArrayList<GroceryItem> getMilk() {return Milk;}
    public void setMilk(ArrayList<GroceryItem> milk) {
        this.add(milk);
        this.Milk = milk;
    }
    public ArrayList<GroceryItem> getBread() {return Bread;}
    public void setBread(ArrayList<GroceryItem> bread) {
        this.add(bread);
        this.Bread = bread;
    }
    public ArrayList<GroceryItem> getCookies() {return Cookies;}
    public void setCookies(ArrayList<GroceryItem> cookies) {
        this.add(cookies);
        this.Cookies = cookies;
    }
    public ArrayList<GroceryItem> getApples() {return Apples;}
    public void setApples(ArrayList<GroceryItem> apples) {
        this.add(apples);
        this.Apples = apples;
    }
    public int getError() {return Error;}
    public void setError(int error) {this.Error = error;}

    public void addToMilk(GroceryItem milk){
        this.Milk.add(milk);
    }

    public void addToBread(GroceryItem bread){
        this.Bread.add(bread);
    }

    public void addToApples(GroceryItem apples){
        this.Apples.add(apples);
    }

    public void addToCookies(GroceryItem cookies){
        this.Cookies.add(cookies);
    }

    public void incrementError() {
        this.Error = getError() + 1;
    }

    public void countMilkPrices(){
        ArrayList<Double> prices = new ArrayList<>();
        for (GroceryItem item : getMilk()){
            if (!item.getPrice().isEmpty()){
                prices.add(Double.valueOf(item.getPrice()));
            }
        }
        milkPriceCount = prices.size();

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

        this.milkPrices = allPrices;
    }

    public void countBreadPrices(){
        ArrayList<Double> prices = new ArrayList<>();
        for (GroceryItem item : getBread()){
            if (!item.getPrice().isEmpty()){
                prices.add(Double.valueOf(item.getPrice()));
            }
        }
        breadPriceCount = prices.size();

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

        this.breadPrices = allPrices;
    }

    public void countCookiesPrices(){
        ArrayList<Double> prices = new ArrayList<>();
        for (GroceryItem item : getCookies()){
            if (!item.getPrice().isEmpty()){
                prices.add(Double.valueOf(item.getPrice()));
            }
        }
        cookiePriceCount = prices.size();

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

        this.cookiesPrices = allPrices;
    }

    public void countApplesPrices(){
        ArrayList<Double> prices = new ArrayList<>();
        for (GroceryItem item : getApples()){
            if (!item.getPrice().isEmpty()){
                prices.add(Double.valueOf(item.getPrice()));
            }
        }
        applePriceCount = prices.size();

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

        this.applesPrices = allPrices;
    }

    public void countAllPrices(){
        countMilkPrices();
        countBreadPrices();
        countCookiesPrices();
        countApplesPrices();
    }

    public int getMilkPriceCount(){
        return milkPriceCount;
    }

    public int getBreadPriceCount(){
        return breadPriceCount;
    }

    public int getCookiePriceCount(){
        return cookiePriceCount;
    }

    public int getApplePriceCount(){
        return applePriceCount;
    }

    public TreeMap<Double, Integer> getMilkPrices(){
        return milkPrices;
    }

    public TreeMap<Double, Integer> getBreadPrices(){
        return breadPrices;
    }

    public TreeMap<Double, Integer> getCookiesPrices(){
        return cookiesPrices;
    }

    public TreeMap<Double, Integer> getApplesPrices(){
        return applesPrices;
    }
}
