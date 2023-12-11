import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroceryItem {
    String name;
    String price;
    String type;
    String expiration;
    Pattern pattern;
    Matcher matcher;

    public GroceryItem(String segment) {
        this.name = extractName(segment);
        this.price = extractPrice(segment);
        this.type = extractType(segment);
        this.expiration = extractExpiration(segment);
    }

    public GroceryItem(String name, String price, String type, String expiration) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.expiration = expiration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getExpiration() {
        return expiration;
    }

    public String extractName(String segment){
        pattern = Pattern.compile("[nN]..[eE]:(\\w*);", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(segment);
        if (matcher.find()){
            return matcher.group(0);
        }
        else {
            return "";
        }
    }

    public String extractPrice(String segment){
        pattern = Pattern.compile("[pP]...[eE]:(\\d\\.\\d\\d);", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(segment);
        if (matcher.find()){
            return matcher.group(0);
        }
        else {
            return "";
        }
    }

    public String extractType(String segment){
        pattern = Pattern.compile("[tT]..[eE]:(\\w*);", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(segment);
        if (matcher.find()){
            return matcher.group(0);
        }
        else {
            return "";
        }
    }

    public String extractExpiration(String segment){
        pattern = Pattern.compile("[eE]........[nN]:(.*)##", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(segment);
        if (matcher.find()){
            return matcher.group(0);
        }
        else {
            return "";
        }
    }
}
