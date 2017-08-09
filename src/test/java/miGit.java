/**
 * Created by cold on 2017/7/8.
 */
public class miGit {
    public static int getSplitNode(String[] matrix, int indexA, int indexB) {
        int n = matrix.length;
        StringBuffer branchA = new StringBuffer(), branchB = new StringBuffer();
        branchA.append(indexA);
        branchB.append(indexB);
        while (indexA != 0){
            for(int i = 0; i < n; i++){
                if(matrix[i].charAt(indexA) == '1'){
                    branchA .insert(0,i);
                    indexA = i;
                    break;
                }
            }
        }
        while (indexB != 0){
            for(int i = 0; i < n; i++){
                if(matrix[i].charAt(indexB) == '1'){
                    branchB.insert(0,i);
                    indexB = i;
                    break;
                }
            }
        }

        int min = branchA.length() < branchB.length() ? branchA.length():branchB.length();
        for(int k = min-1; k >= 0; k--){
            if(branchA.charAt(k) == branchB.charAt(k))return  k;
        }
       return 0;
    }
    public static void main(String args[]){
        String[] matrix ={"01011","10100","01000","10000","10000"};
       System.out.println(getSplitNode(matrix,1,2));
    }
}
