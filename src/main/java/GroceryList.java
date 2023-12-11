
import java.util.ArrayList;

public class GroceryList extends ArrayList<ArrayList<GroceryItem>> {

    ArrayList<GroceryItem> Milk;
    ArrayList<GroceryItem> Bread;
    ArrayList<GroceryItem> Cookies;
    ArrayList<GroceryItem> Apples;
    int Error;

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


    public int countError (){

        int errorCount = 0;
        for (ArrayList<GroceryItem> list : this) {
            for (GroceryItem item : list) {
                if (item.getName().isEmpty()) {
                }
                    errorCount++;
                if (item.getPrice().isEmpty()) {
                    errorCount++;
                }
                if (item.getType().isEmpty()) {
                    errorCount++;
                }
                if (item.getExpiration().isEmpty()) {
                    errorCount++;
                }
            }
        }

        return errorCount;
    }
}
