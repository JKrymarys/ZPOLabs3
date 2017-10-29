package lab3;

import com.google.gson.Gson;
import lab3.Question;
import sun.jvm.hotspot.utilities.Assert;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class EnglishQuiz {



    private static Question[] load()
    {
        Gson gson = new Gson();
        Question[] questions = {};
        Question q;
        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("/Users/admin/eclipse-workspace/ZPOlabs3/src/lab3/PolEngTest.json"));

            //convert the json string back to object
            questions = gson.fromJson(br, Question[].class);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e)
        {
            System.out.println("Null pointer");
        }finally
        {
            return questions;
        }

    }


    public static void Quiz()
    {
        List<Question> pula = new ArrayList<Question>(Arrays.asList(load()));
        Collections.shuffle(pula);
        pula = pula.subList(0,5);
        int score = 0;
        long startTime = System.currentTimeMillis();
        for(Question q: pula)
        {
            if(AskQuestion(q))
            {
                score +=1;
            }

        }

        long elapsedTime = System.currentTimeMillis() - startTime;

        Date date = new Date(elapsedTime);
        DateFormat formatter = new SimpleDateFormat("mm:ss:SSS");
        String dateFormatted = formatter.format(date);

        System.out.println(dateFormatted);
        System.out.println(score);
    }

    private static boolean AskQuestion(Question q) {
        String userInput =   JOptionPane.showInputDialog("Translate into English: " + q.pl);
        System.out.println( userInput );
        boolean  isCorrect = false;

            for (String s : q.correct)
            {
                if(userInput.equals(s))
                {
                    isCorrect = true;
                }
            }

        System.out.println("is correct? : " + isCorrect);

        if(isCorrect)
        {
            return true;
        }
        else
        {
            return false;
        }

    }



    public static void main(String[] args) {

    Quiz();
    }
}
