package Services;

public class Counter implements AutoCloseable{
    static int sum;
    {
        sum = 0;
    }

    public void add() {
        sum++;
    }
    public int getSum(){
        return sum;
    }

    @Override
    public void close() {
        System.out.println("Services.Counter closed");
    }
}
