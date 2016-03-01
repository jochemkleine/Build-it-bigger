package com.jochemkleine;

import java.util.Random;

public class JokeTeller {

    public String getJoke () {
        Random r = new Random();
        int jokeNr = r.nextInt(4);

        switch(jokeNr) {
            case 1:
                return "\"Son, I wanted to let you know you were adopted,\" my dad told me.  " +
                        "\n \"Are you kidding? Really?\" I shouted. " +
                        "\n \"Yup, get ready,\" he said. \"They'll be picking you up in about an hour.\" ";

            case 2:
                return "Yo girl, are you a zero APR loan?" +
                        " \n Because I don't really understand your terms and you keep saying you have no interest.";
            case 0:
                return "What's a pirate's least favourite letter?" +
                        "\n Dear Sir," +
                        "\n We are writing to you because you have violated copyright ...";
            case 3:
                return "What's the difference between Dubai and Abu Dhabi?" +
                        "\n People in Dubai don't like the Flintstones but people in Abu Dhabi doooooo.";
        }
        return "joke out of bounds";
    }

}
