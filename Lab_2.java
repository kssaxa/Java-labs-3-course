import java.util.ArrayList;

public class Lab_2 {
private int[] samples;
 public static  int limitAmplitude(int limit,  ArrayList<Integer> soundArray)
 {
     int numChanges=0;
     for (int i=0;i<soundArray.size();i++)
     {
         if (soundArray.get(i)>limit)
         {
             soundArray.remove(i);
             soundArray.add(i,limit);
             numChanges++;
         }

     }
    return numChanges;
 }
 public static void trimSilenceFromBeginning( ArrayList<Integer> soundArray){
     ArrayList<Integer> silenceList = new ArrayList<>();

     for (int i=0;i<soundArray.size();i++) {
         if (soundArray.get(i) == 0) {
             soundArray.remove(i);
         }
     }

 }
    public static void main (String[] args)
    {
        ArrayList<Integer> mas= new ArrayList<>();
        int[] newlist = new int[] {200,100,500,30,0,45,87,55,7,9};
        for (int i=0;i<newlist.length;i++)
        {
            mas.add(newlist[i]);
        }

        System.out.println( limitAmplitude(100, mas));
        trimSilenceFromBeginning(mas);
        System.out.println(mas);

    }
}