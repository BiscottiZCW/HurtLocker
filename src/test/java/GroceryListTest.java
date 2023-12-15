import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GroceryListTest {
    @Test
    public void testGetMilk() {
        ArrayList<GroceryItem> Milk = new ArrayList<>();
        GroceryItem groceryItem = new GroceryItem("name", "price", "type", "expiration");
        GroceryList groceryList = new GroceryList();
        Milk.add(groceryItem);
        groceryList.setMilk(Milk);
        ArrayList<GroceryItem> actual = groceryList.getMilk();

        Assert.assertEquals(Milk, actual);
    }

    @Test
    public void testSetMilk() {
        ArrayList<GroceryItem> Milk = new ArrayList<>();

        GroceryItem groceryItem = new GroceryItem("name", "price", "type", "expiration");
        Milk.add(groceryItem);
        int expected =1;

        GroceryList groceryList = new GroceryList();
        groceryList.setMilk(Milk);
        int actual = groceryList.Milk.size();

        Assert.assertEquals(expected, actual );
    }
    @Test
    public void testGetBread() {
        ArrayList<GroceryItem> Bread = new ArrayList<>();
        GroceryItem groceryItem = new GroceryItem("name", "price", "type", "expiration");
        GroceryList groceryList = new GroceryList();
        Bread.add(groceryItem);
        groceryList.setBread(Bread);
        ArrayList<GroceryItem> actual = groceryList.getBread();

        Assert.assertEquals(Bread, actual);
    }
    @Test
    public void testSetBread() {
        ArrayList<GroceryItem> Bread = new ArrayList<>();

        GroceryItem groceryItem = new GroceryItem("name", "price", "type", "expiration");
        Bread.add(groceryItem);
        int expected =1;

        GroceryList groceryList = new GroceryList();
        groceryList.setBread(Bread);
        int actual = groceryList.Bread.size();

        Assert.assertEquals(expected, actual );
    }
    @Test
    public void testGetCookies() {
        ArrayList<GroceryItem> Cookies = new ArrayList<>();
        GroceryItem groceryItem = new GroceryItem("name", "price", "type", "expiration");
        GroceryList groceryList = new GroceryList();
        Cookies.add(groceryItem);
        groceryList.setCookies(Cookies);
        ArrayList<GroceryItem> actual = groceryList.getCookies();

        Assert.assertEquals(Cookies, actual);
    }
    @Test
    public void testSetCookies() {
        ArrayList<GroceryItem> Cookies = new ArrayList<>();

        GroceryItem groceryItem = new GroceryItem("name", "price", "type", "expiration");
        Cookies.add(groceryItem);
        int expected =1;

        GroceryList groceryList = new GroceryList();
        groceryList.setCookies(Cookies);
        int actual = groceryList.Cookies.size();

        Assert.assertEquals(expected, actual );
    }
    @Test
    public void testGetApples() {
        ArrayList<GroceryItem> Apples = new ArrayList<>();
        GroceryItem groceryItem = new GroceryItem("name", "price", "type", "expiration");
        GroceryList groceryList = new GroceryList();
        Apples.add(groceryItem);
        groceryList.setApples(Apples);
        ArrayList<GroceryItem> actual = groceryList.getApples();

        Assert.assertEquals(Apples, actual);
    }
    @Test
    public void testSetApples() {
        ArrayList<GroceryItem> Apples = new ArrayList<>();

        GroceryItem groceryItem = new GroceryItem("name", "price", "type", "expiration");
        Apples.add(groceryItem);
        int expected =1;

        GroceryList groceryList = new GroceryList();
        groceryList.setApples(Apples);
        int actual = groceryList.Apples.size();

        Assert.assertEquals(expected, actual );
    }
    @Test
    public void testGetError() {
        GroceryList groceryList = new GroceryList();
        groceryList.setError(5);

        Assert.assertEquals(5, groceryList.getError());
    }

    @Test
    public void testIncrementError() {
        GroceryList groceryList = new GroceryList();
        groceryList.incrementError();

        Assert.assertEquals(1, groceryList.getError());
    }

    @Test
    public void testAddToMilk() {
        GroceryList groceryList = new GroceryList();
        groceryList.addToMilk(new GroceryItem(""));

        Assert.assertEquals(1, groceryList.getMilk().size());
    }

    @Test
    public void testAddToBread() {
        GroceryList groceryList = new GroceryList();
        groceryList.addToBread(new GroceryItem(""));

        Assert.assertEquals(1, groceryList.getBread().size());
    }

    @Test
    public void testAddToApples() {
        GroceryList groceryList = new GroceryList();
        groceryList.addToApples(new GroceryItem(""));

        Assert.assertEquals(1, groceryList.getApples().size());
    }

    @Test
    public void testAddToCookies() {
        GroceryList groceryList = new GroceryList();
        groceryList.addToCookies(new GroceryItem(""));

        Assert.assertEquals(1, groceryList.getCookies().size());
    }


}