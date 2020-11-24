//public class UrlFixer {
//    public static void main(String... args) {
//        String url = "https//www.reddit.com/r/nevertellmethebots";
//
//        // Accidentally I got the wrong URL for a funny subreddit. It's probably "odds" and not "bots"
//        // Also, the URL is missing a crucial component, find out what it is and insert it too!
//        // Try to solve it more than once using different String functions!
//
//        System.out.println(url);
//    }
//}

import java.lang.String;

public class UrlFixer {
    public static void main(String[] args) {
        String url = "https//www.reddit.com/r/nevertellmethebots";

        url = url.replace("bots", "odds");
        String firstPart = url.substring(0, 5);
        String secoundPart = url.substring(5);
        System.out.println(firstPart + ":" + secoundPart);

        url = "https//www.reddit.com/r/nevertellmethebots";

        url = url.replace("https", "https:");
        System.out.println(url.replace("bots", "odds"));


    }
}
