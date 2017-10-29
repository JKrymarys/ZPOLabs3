package lab3;

import java.util.Arrays;
import java.util.Locale;
import java.text.Collator;


public class task1
{

    public task1()
    {
        Locale pl = new Locale("pl_PL");

        java.text.Collator collator = Collator.getInstance(pl);
    }


    public static void sortStrings(Collator collator, String[] words) {
        String temp = null;

        for (int i = 0; i < words.length; i++)
        {
            for (int j = 0; j < (words.length - 1); j++)
            {
                if (collator.compare(words[j], words[j + 1]) >= 0)
                {
                    temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                } else
                {

                }
            }
        }
    }


    public static void fastSortStrings(Collator collator, String[] words)
    {
        Arrays.sort(words, collator);
    }

    public static void fastSortStrings2(Collator collator, String[] words)
    {
        Arrays.sort(words, (String a, String b) -> {
            return collator.compare(a,b);
        });
    }

}
