import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("note.txt");
        Scanner reader = new Scanner(file);

        String line = null;
        while (reader.hasNextLine()) {
            line = reader.nextLine();//Чтение строки
        }
        reader.close();

        String[] arr = line.split("\\.");
        int len = arr.length;
        for (int i = 0; i < len; i++)
        {
            arr[i] = arr[i].trim();
        }
        System.out.println(Arrays.toString(arr));

        Operation lambda = (value1, value2) -> { //сравнение строк на длинну
            if (value1.length() > value2.length())
                return value1;
            else
                return value2;
        };

        Operation lambda1 = (value1, value2) ->{ //сравнение строк на заглавные буквы
            int j = 0, k = 0;
            boolean ch = false;
            char let;
            for (int i=0; i < value1.length(); i++){
                let = value1.charAt(i);
                ch = Character.isUpperCase(let);// заглавная
                if (ch)
                    j++;
            }
            for (int i=0; i < value2.length(); i++){
                let = value2.charAt(i);
                ch = Character.isUpperCase(let);
                if (ch)
                    k++;
            }
            if (j>k)
                return value1;
            else
                return value2;
        };


        Operation lambda2 = (value1, value2) ->{ //Сравнение строк на гласные
            int j = 0, k = 0;
            boolean ch = false;
            Pattern letter = Pattern.compile("(?iu)[аеёиоуыэюя]");

            Matcher mat = letter.matcher(value1);
            while (mat.find()){
                j++;
            }

            mat = letter.matcher(value2);
            while (mat.find()){
                k++;
            }

            if (j>k)
                return value1;
            else
                return value2;
        };

        String max = " ";
        for (int i=0; i<len; i++){
            max = lambda.getResult(arr[i], max);
        }
        System.out.println(max);

        max = " ";
        for (int i=0; i<len; i++){
            max = lambda1.getResult(arr[i], max);
        }
        System.out.println(max);

        max = " ";
        for (int i=0; i<len; i++){
            max = lambda2.getResult(arr[i], max);
        }
        System.out.println(max);
    }
}