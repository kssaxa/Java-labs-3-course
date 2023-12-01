import java.util.Arrays;
import java.util.ArrayList;

public class Lab_1
{
    public static boolean isSelfDivisor(int number)
    {
        int count_Sh = 0;
        int count_del = 0;
        int prov = number;
        int prov1;
        while (prov != 0){ //Условие выхода
            prov1 = prov%10;
            if (number % prov1 == 0){
                count_del++;
            }
            count_Sh++;
            prov=prov/10;
        }
        if(count_del == count_Sh)
            return true;
        
        else
            return false;
        
    }

    public static ArrayList<Integer> firstNumSelfDivisors(int start, int num)
    {
        int count_mas = 0;
        int count_num = num;
        int d_start = start;
        ArrayList<Integer> masDivisors = new ArrayList<>();
        //int[] masDivisors = new int[];
        while(count_num >0){
            if (isSelfDivisor(d_start) == true){
                masDivisors.add(d_start);
                count_mas++;
                count_num--;

            }
            d_start++;
        }
        return masDivisors;
    }

    public static void main (String[] args)
    {
        String print;
        if(isSelfDivisor(158)){
            print="True";
        }
        else{
            print = "False";
        }
        System.out.println(print);
        //System.out.println("128: " + isSelfDivisor(128));
        //System.out.println("26: " + isSelfDivisor(26));
        //System.out.println("120: " + isSelfDivisor(120));
        //System.out.println("102: " + isSelfDivisor(102));

        System.out.println(firstNumSelfDivisors(111,3));

    }
}
