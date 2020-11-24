//public class TodoPrint {
//    public static void main(String... args){
//        String todoText = " - Buy milk\n";
//        // Add "My todo:" to the beginning of the todoText
//        // Add " - Download games" to the end of the todoText
//        // Add " - Diablo" to the end of the todoText but with indention
//
//        // Expected output:
//
//        // My todo:
//        //  - Buy milk
//        //  - Download games
//        //      - Diablo
//
//        System.out.println(todoText);
//    }
//}

public class TodoPrint {
    public static void main(String[] args) {
        String todoText = " - Buy milk\n";
        String todo = "My todo:\n";
        String together = todo.concat(todoText);
        String game = " - Download games\n \t";
        String longer = together.concat(game);
        String end = " - Diablo";


        System.out.println(longer + end);

    }
}
