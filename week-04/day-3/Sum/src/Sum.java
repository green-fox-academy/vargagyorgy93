import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.List;

public class Sum {



    public int sum (ArrayList arrayList){
        Integer sum = 0;
        ArrayList<Integer> integer = new ArrayList<>(arrayList);
        for (Integer sums: integer) {
            sum += sums;
        }
        return sum;
    }

}
