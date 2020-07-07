package nix.service;

import java.util.Map;

public interface StringService {
    public int amountOfAllSymbols(String text);
    public Map<Character,Integer> sortedOrderOfChars(String text);
    public int amountOfAllWords(String text);
    public Map<String,Integer> sortedOrderOfWords(String text);
    public String reverseOfText (String text);
}
