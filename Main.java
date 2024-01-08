import java.util.regex.*;
/*выходные данные статьи
 (авторы, название, журнал, номер, год, страницы).
 */
public class Main {
    static boolean isCorrect(String[] input) {
        if (!input[0].matches("^[А-ЯЁ][а-яё]+\\s[А-ЯЁ]\\.[А-ЯЁ]\\.$")) { //для ФИО
            return false;
        }
        if (!input[1].matches("([А-Я][а-я]+\\s*)+")) { //для Названия
            return false;
        }
        if (!input[2].matches("([А-Я][а-я]+\\s*)+")) { //для журнала
            return false;
        }
       if (!input[3].matches("^[0-9]+$")) { //для номера
            return false;
        }
        if (!input[4].matches("^(1[5-9][0-9]{2}|20[01][0-9]|202[0-4])$")) { //для года от 1500 до 2024
            return false;
        }
        if (!input[5].matches("^[0-9]+-[0-9]+$")) { //для страниц до 1000
            return false;
        }
     return true;
    }
    public static void main(String[] args) {
        String autor = "Иванов Иван Иванович";
        String name = "Название";
        String magazine = "Журнал";
        String number= "10";
        String year = "2023";
        String list = " 123-125";

        String[] input = {autor, name, magazine, number, year,list};

        if (isCorrect(input)) {
            System.out.println("Данные корректны");
        } else {
            System.out.println("Данные некорректны");
        }
    }



}