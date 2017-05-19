/**
 * Created by cold on 2017/5/17.
 */
public class Counter{
    private String id;
    private int count = 0;
    public Counter(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void increment(){
        this.count++;
    }
    public int tally(){
        return this.count;
    }
    @Override
    public String toString() {
        return "Counter{" +
                "id='" + id + '\'' +
                ", count=" + count +
                '}';
    }
}
