import java.util.*;

/**
 * Created by cold on 2017/5/22.
 */
public class hat {
    public static int BuyHat(ArrayList<Integer> list){
        int result = 0;
        Set<Integer> setInt = new TreeSet<Integer>();
        setInt.addAll(list);

        Iterator<Integer> iterator = setInt.iterator();
        int j=0;
        while(iterator.hasNext()&&j<3){
            result = iterator.next();
            j=j+1;
        }

        return result;
    }


    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            int randInt = (int) (Math.random() * 1000);
            list.add(randInt);
        }
        System.out.println("输入数组为：");
        for(Integer li:list){
            System.out.print(li+", ");
        }
        System.out.println();
        int value = BuyHat(list);
        System.out.println("第三便宜的帽子价格："+value);
    }
}
