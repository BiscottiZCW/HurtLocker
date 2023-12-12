import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class JerksonIOTest {

    @Test
    public void createFormatStringTest(){
        GroceryList groceryList = new GroceryList();
        ArrayList<GroceryItem> milk = new ArrayList<>();
        ArrayList<GroceryItem> apples = new ArrayList<>();
        ArrayList<GroceryItem> bread = new ArrayList<>();
        ArrayList<GroceryItem> cookies = new ArrayList<>();
        milk.add(new GroceryItem("MILK", "3.23", "food", "1/25/2018"));
        apples.add(new GroceryItem("apples", "0.25", "food", "2/27/2020"));
        apples.add(new GroceryItem("ApPlEs", "0.23", "food", "2/27/2020"));
        apples.add(new GroceryItem("Apples", "0.23", "food", "2/27/2020"));
        bread.add(new GroceryItem("Bread", "1.23", "food", "3/19/2021"));
        cookies.add(new GroceryItem("Cookies", "2.25", "food", "4/15/2022"));
        groceryList.setMilk(milk);
        groceryList.setBread(bread);
        groceryList.setApples(apples);
        groceryList.setCookies(cookies);
        groceryList.setError(2);

        String actual = JerksonIO.createFormatString();
        String expected = "name:    Milk \t\t seen: 1 time\n" +
                            "============= \t \t =============\n" +
                            "Price: \t 3.23\t\t seen: 1 time\n" +
                            "\n" +
                            "name:   Bread\t\t seen: 1 time\n" +
                            "=============\t\t =============\n" +
                            "Price:   1.23\t\t seen: 1 time\n" +
                            "-------------\t\t -------------\n" +
                            "\n" +
                            "name: Cookies     \t seen: 1 time\n" +
                            "=============     \t =============\n" +
                            "Price:   2.25        seen: 1 time\n" +
                            "-------------        -------------\n" +
                            "\n" +
                            "name:  Apples     \t seen: 3 times\n" +
                            "=============     \t =============\n" +
                            "Price:   0.25     \t seen: 1 time\n" +
                            "-------------     \t -------------\n" +
                            "Price:   0.23  \t \t seen: 2 times" +
                            "\n" +
                            "Errors         \t \t seen: 2 times";
        Assert.assertEquals(expected, actual);
    }
}
