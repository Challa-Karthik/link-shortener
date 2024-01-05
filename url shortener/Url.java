import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.Scanner;

public class Url {
    public static void main(String[] args){
        Url UrlShortener = new Url();
        Scanner input= new Scanner(System.in);
        System.out.println("enter a long url : ");
        String LongUrl =input.nextLine();
        String ShortUrl=UrlShortener.shortenUrl(LongUrl);
        System.out.println("Shortened url is : " + ShortUrl);
        System.out.println("Enter a short url : ");
        String SmallUrl=input.nextLine();
        String expandUrl=UrlShortener.getOriginalUrl(SmallUrl);
        System.out.println("Expanded Url is : " + (expandUrl != null ? expandUrl : "Url not Found"));

    }
    private static final String basic_url ="htttp://www.gooogle.in/";
    private Map<String,String> urlMap;
    public Url() {
        this.urlMap=new HashMap<>();

    }
    public String shortenUrl(String longUrl){
        if(urlMap.containsValue(longUrl)){
            for(Map.Entry<String,String> entry : urlMap.entrySet()){
                 if(entry.getValue().equals(longUrl)){
                    return entry.getKey();
                 }
            }
        }
    String shortKey = generateShortKey();
    String shortUrl = basic_url + shortKey;
    urlMap.put(shortUrl,longUrl);
    return shortUrl;
    }
    public String getOriginalUrl(String shortUrl){
        return urlMap.get(shortUrl);
    }
    private String generateShortKey(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().substring(0,7);
    }
}