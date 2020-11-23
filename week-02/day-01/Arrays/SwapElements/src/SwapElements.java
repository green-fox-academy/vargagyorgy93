// - Create an array variable named `orders`
//   with the following content: `["first", "second", "third"]`
// - Swap the first and the third element of `orders`

import java.util.Arrays;

public class SwapElements {
    public static void main(String[] args) {
        String[] orders = {"first", "secound", "third"};

        String empty = orders[0];

        orders[0] = orders[2];
        orders[2] = empty;

        System.out.println(Arrays.toString(orders));
    }
}
