
import java.util.TreeMap;

public class Convert
{
    TreeMap<Character, Integer> rimKey = new TreeMap<>();
    TreeMap<Integer, String> arabKey = new TreeMap<>();


    public Convert()
    {
        // Ключи для римских цифр
        rimKey.put('I', 1);
        rimKey.put('V', 5);
        rimKey.put('X', 10);
        rimKey.put('L', 50);
        rimKey.put('C', 100);
        rimKey.put('D', 500);
        rimKey.put('M', 1000);



        arabKey.put(1000, "M");
        arabKey.put(900, "CM");
        arabKey.put(500, "D");
        arabKey.put(400, "CD");
        arabKey.put(100, "C");
        arabKey.put(90, "XC");
        arabKey.put(50, "L");
        arabKey.put(40, "XL");
        arabKey.put(10, "X");
        arabKey.put(9, "IX");
        arabKey.put(5, "V");
        arabKey.put(4, "IV");
        arabKey.put(1, "I");



    }

    // Создаем новый метод, чтобы проверять ключи нашей карты.
    public boolean isRim(String number)
    {
        //конвертируем из string в char
        return rimKey.containsKey(number.charAt(0));
        // берет 0 символ и если он есть среди наших ключей, то отдает true, и false, если его нет
    }
    public String intToRim(int number){
        String rim = "";
        int arabianKey;
        do {
            arabianKey = arabKey.floorKey(number);
            rim += arabKey.get(arabianKey);
            number -= arabianKey;
        }while (number != 0);
        return rim;
    }
    public int rimToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arab;
        int result = rimKey.get(arr[end]);
        for (int i = end - 1; i>=0; i--) {
            arab = rimKey.get(arr[1]);

            if (arab < rimKey.get(arr[i+1])){
                result -= arab;
            }else {
                result += arab;
            }

        }
        return result;

    }
}
