package lab3;

import com.google.gson.Gson;
import lab3.Question;
import sun.jvm.hotspot.utilities.Assert;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

            System.out.printf("load");
            for( String s : questions[3].correct)
            {
                System.out.println(s);
            }


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

        for(Question q: pula)
        {
            if(AskQuestion(q));
            score +=1;
            System.out.println(score);

        }
    }

    private static boolean AskQuestion(Question q) {
        String userInput =   JOptionPane.showInputDialog("Translate into English: " + q.pl);
        System.out.println( userInput );
        boolean  isCorrect = false;

            for (String s : q.correct)
            {
                if(userInput == s)
                    isCorrect = true;
            }

        if(isCorrect)
            return true;
        else
            return false;

    }



    public static void main(String[] args) {

    Quiz();
    }
}
