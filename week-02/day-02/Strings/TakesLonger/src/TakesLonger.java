//public class TakesLonger {
//    public static void main(String... args) {
//        String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";
//
//        // When saving this quote a disk error has occurred. Please fix it.
//        // Add "always takes longer than" to the StringBuilder (quote) between the words "It" and "you"
//        // Using pieces of the quote variable (instead of just redefining the string)
//
//        System.out.println(quote);
//    }
//}

public class TakesLonger {
    public static void main(String[] args) {
        String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";

        String firstPart = quote.substring(0, 21);
        String secoundPart = quote.substring(21);
        String missing = "always takes longer than";

        System.out.println(firstPart + missing + secoundPart);
    }
}
