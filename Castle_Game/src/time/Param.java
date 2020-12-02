package time;

public class Param {
    private int value;
    private int limit;

    public Param(int value, int limit) {
        this.value = value;
        this.limit = limit;
    }

    public void increase(int i) {
        value += i;
    }

    public int getValue() {
        return value;
    }

    public int getLimit() {
        return limit;
    }

    public void setValue(int v) {
        value = v;
    }

}
