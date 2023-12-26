import java.util.Arrays;

public class Main {
    //сумма строки
    public static int arraySum(int[] arr) //метод для подсчета суммы эл-ов массива
    {
        int sum = 0;
        for (int i=0; i<arr.length; i++){
            sum+= arr[i];
        }
        return sum;

    }
    public static int[] rowSums(int[][] arr2D, int m, int n){ //метод для подсчета суммы эл-тов строк
        int[] sumArray = new int[m];
        int[] stringArray = new int[n];
        int sum;
        for (int i = 0; i < m; i++)
        {
            for(int j = 0; j <n; j++)
            {
                stringArray[j] = arr2D[i][j];
            }
            sum = arraySum(stringArray);
            sumArray[i]=sum;
        }
        return sumArray;
    }
    //метод для опр разноообразностиы
    public static boolean isDeverse(int[][] arr2D,int m, int n){
        int[] provArray = new int[m];
        provArray = rowSums(arr2D,m,n);
        int prov = 0;
        for(int i=0;i<m-1;i++){
            if (provArray[i]==provArray[i+1])
                prov++;
        }
        if(prov>0)
            return false;
        else
            return true;

    }
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] mas = {{1,3,5},{1,3,5},{1,8,9}};
        int[] mas1 = {1,1,1,1};
        System.out.println(arraySum(mas1));
        System.out.println(Arrays.toString(rowSums(mas, m, n)));
        System.out.println(isDeverse(mas,m,n));
    }
}
