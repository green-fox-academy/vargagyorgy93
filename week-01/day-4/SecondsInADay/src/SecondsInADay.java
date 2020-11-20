public class SecondsInADay {
    public static void main(String[] args) {


        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        int PastMinutesInSecound = currentMinutes * 60;
        int PastHoursInSecound = currentHours * 3600;
        int PastedTotalTimeInSecound = PastHoursInSecound + PastMinutesInSecound + currentSeconds;
        int FullDayInSecounds = 24 * 3600;

        System.out.println("A napból hátralévő másodpercek száma: " + (FullDayInSecounds - PastedTotalTimeInSecound));

    }
}
