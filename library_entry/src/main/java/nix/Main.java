package nix;

import nix.service.impl.StringServiceImpl;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main {


    public static void main(String[] args){
        String text = "";
        try {
            text = Files.readString(Path.of("src/main/resources/text.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Text: \n"+text);
        StringServiceImpl process = new StringServiceImpl();
        System.out.println();
        System.out.println("Задание 1\nКоличество всех символов в строке: "+ process.amountOfAllSymbols(text));
        System.out.println("Отсортирована по порядку количества встречаний: \n"+process.sortedOrderOfChars(text));
        System.out.println();
        System.out.println("Задание 2\nКоличество всех слов в строке: "+ process.amountOfAllWords(text));
        System.out.println("Отсортирована по порядку количества встречаний: \n"+process.sortedOrderOfWords(text));
        System.out.println();
        System.out.println("Задание 3\nРеверс всех слов в каждом предложении: \n"+ process.reverseOfText(text));
    }

}
