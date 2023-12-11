import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GroceryItemTest {
    String name;
    String price;
    String type;
    String expiration;
    GroceryItem groceryItem;
    String exp1;
    String exp2;
    String expSyb1;
    String expSyb2;
    String expError1;
    String expError2;
    String expError3;
    String expError4;

    @Before
    public void setup(){
         name = "name";
         price = "0.00";
         type = "food";
         expiration = "01-03-2034" ;
        exp1 = "nAme:Milk;price:3.23;type:Food;expiration:1/25/2016##";// nor
        expSyb1 = "nAMe:cookies;price:3.23?type:Food;expiration:1/26/2016##";// change sy
        expSyb2 = "naMe:co0kies;price:0.23@type:Food;expiration:1/26/2019##";// change sy
        expError1 = "NaMe:;price:3.25;type:Food;expiration:1/25/2046##"; // error1
        expError2 = "NaMe:BRead;price:;type:Food;expiration:1/25/2046##"; // error2
        expError3 = "NaMe:cookie;price:3.25;type:Food;expiration:##"; // error3
        expError4 = "NaMe:BRead;price:0.45;type:;expiration:1/25/2046##"; // error4
        exp2= "NAMe:BRead;price:5.23;type:Food;expiration:4/20/2016##";//  nor

        //   need to set up a constructor.
       groceryItem = new GroceryItem(name, price, type , expiration);
// ops
    }
     // constructor test
     @Test
     public void constructorTest(){
        Assert.assertNotNull(groceryItem);
     }

    @Test
    public void setNameTest(){
         groceryItem.setName("cookies");
        String actual = groceryItem.getName();
         String expected = "cookies";
         Assert.assertEquals(expected, actual);
     }
    // test the obj name


    // test the obj price as a string
    @Test
    public void getPriceTest(){
        String actual = groceryItem.getPrice();
        String expected = "0.00";
        Assert.assertEquals(expected, actual);
    }

    // test the obj type as a string
    @Test
    public void getTypeTest(){
        String actual = groceryItem.getType();
        String expected = "food";
        Assert.assertEquals(expected, actual);
    }

    // test the obj expiration  as a string
    @Test
    public void getExpirationTest(){
        String actual = groceryItem.getExpiration();
        String expected = "01-03-2034";
        Assert.assertEquals(expected, actual);

    }
@Test
    public void extractNameTest(){


    String actual = groceryItem.extractName(exp1);
         String expect = "Milk";
 Assert.assertEquals(expect,actual);
}
    @Test
    public void extractName2Test(){


        String actual = groceryItem.extractName(exp2);
        String expect = "BRead";
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void extractPriceTest(){

        String actual = groceryItem.extractPrice(exp1);
        String expect = "3.23";
        Assert.assertEquals(expect,actual);
    }
    @Test
    public void extractPrice2Test(){

        String actual = groceryItem.extractPrice(exp2);
        String expect = "5.23";
        Assert.assertEquals(expect,actual);
    }
    @Test
    public void extractType1Test(){


        String actual = groceryItem.extractType(exp1);
        String expect = "Food";
        Assert.assertEquals(expect,actual);
    }
    @Test
    public void extractType2Test(){


        String actual = groceryItem.extractType(exp2);
        String expect = "Food";
        Assert.assertEquals(expect,actual);
    }
    @Test
    public void extractExpirationTest(){
        String actual = groceryItem.extractExpiration(exp1);
        String expect = "1/25/2016";
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void extractExpiration2Test(){
        String actual = groceryItem.extractExpiration(exp2);
        String expect = "4/20/2016";
        Assert.assertEquals(expect,actual);
    }

    @Test
    public void errorNameTest(){

       String actual = groceryItem.extractName(expError1);
        String expected = "";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void errorExpirationTest(){
        String actual = groceryItem.extractExpiration(expError3);
        String expected = "";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void errorTypeTest(){

        String actual = groceryItem.extractType(expError4);
        String expected = "";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void errorPriceTest2(){
        String actual = groceryItem.extractPrice(expError2);
        String expected = "";
        Assert.assertEquals(expected, actual);
    }
}
