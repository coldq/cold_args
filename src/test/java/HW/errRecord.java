package HW;

import java.util.*;

/**
 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 处理:
 1.记录最多8条错误记录，对相同的错误记录(即文件名称和行号完全匹配)只记录一条，错误计数增加；(文件所在的目录不同，文件名和行号相同也要合并)
 2.超过16个字符的文件名称，只记录文件的最后有效16个字符；(如果文件名不同，而只是文件名的后16个字符和行号相同，也不要合并)
 3.输入的文件可能带路径，记录文件名称不能带路径
 */
public class errRecord {

public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        LinkedHashMap<String,Integer> ret = new LinkedHashMap<String,Integer>();
        LinkedList<String> res = new LinkedList<String>();
        while (in.hasNext()){
            String[] line = in.nextLine().split(" ");
            int index = line[0].lastIndexOf("\\");
            if(line[0].length() -1 - index > 16){
                line[0] = line[0].substring(line[0].length()-16);
            }else{
                line[0] = line[0].substring(index+1);
            }
            String key = line[0]+" "+ line[1];
            if (ret.containsKey(key)){
                ret.put(key,ret.get(key)+1);
            }else {
                ret.put(key,1);
            }

        }
        Iterator<Map.Entry<String, Integer>> entries = ret.entrySet().iterator();
        while ( entries.hasNext() ){
            Map.Entry<String, Integer> i = entries.next();
            if(res.isEmpty()) res.add(i.getKey());
            else {
                int j = res.size()-1;
                for(; j>=0;j--){
                    if(i.getValue() <= ret.get( res.get(j)) )break;
                }
                res.add(j+1,i.getKey());
            }
        }
        for(int i = 0; i<8&&i<res.size();i++){
            System.out.println(res.get(i)+" "+ret.get(res.get(i)));
        }
    }
}
