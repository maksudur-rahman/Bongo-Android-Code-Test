import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static boolean anagramCheck(char[] str1, char[] str2)
    {
        int lengthStr1 = str1.length;
        int lengthStr2 = str2.length;

        if (lengthStr1 != lengthStr2) {
            return false;
        }


        Arrays.sort(str1);
        Arrays.sort(str2);

        for (int i = 0; i < lengthStr1; i++) {
            if (str1[i] != str2[i]) {
                return false;
            }
        }
        return true;
    
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String firstStr = "",scndStr = "";
        System.out.println("Enter The First String : ");
        firstStr = scanner.nextLine();
        System.out.println("Enter The Second String : ");
        scndStr = scanner.nextLine();
        firstStr = firstStr.replace(" ","");
        scndStr = scndStr.replace(" ","");
        firstStr = firstStr.toLowerCase();
        scndStr = scndStr.toLowerCase();
        char str1[] = firstStr.toCharArray();
        char str2[] = scndStr.toCharArray();
        if (anagramCheck(str1, str2))
            System.out.println("Two strings are anagram.");
        else
            System.out.println("Two strings are not anagram.");
    }
}
