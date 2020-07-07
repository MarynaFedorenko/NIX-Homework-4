package nix;

import nix.service.impl.StringServiceImpl;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DataBuilderTest {
    private static  String text = "";
    private final static StringServiceImpl process = new StringServiceImpl();


    private void build(){
        try {
            text = Files.readString(Path.of("src/main/resources/test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkAmountOfAllSymbols(){
        build();
        assertEquals(process.amountOfAllSymbols(text), 113);
    }

    @Test
    public void checkSortedOrderOfChars(){
        build();

        assertEquals(process.sortedOrderOfChars(text).get('н'), 7);
    }

    @Test
    public void checkAmountOfAllWords(){
        build();
        assertEquals(process.amountOfAllWords(text), 14);
    }

    @Test
    public void checkSortedOrderOfWords(){
        build();
        assertEquals(process.sortedOrderOfWords(text).get("предложений"), 1);
    }

    @Test
    public void checkReverseOfText(){
        build();
        String temp = process.reverseOfText(text);
        String [] words = temp.split("\\s+");
        assertEquals(words[5], "задания");
    }

}
