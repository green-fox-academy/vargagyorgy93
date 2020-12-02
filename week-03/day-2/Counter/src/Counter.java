public class Counter {
    int field = 0;
    int basic = 0;


    public Counter(int fields) {
        this.field = fields;
        this.basic = fields;

    }

    public Counter() {
    }


    public void add(int adder) {
        field += adder;

    }

    public void add() {
        field++;
    }

    public int get() {
        return field;
    }

    public void reset() {
        this.field = this.basic;
    }

    public static void main(String[] args) {

    }

}
