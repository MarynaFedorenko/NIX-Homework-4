package nix.service.impl;

import nix.service.StringService;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class StringServiceImpl implements StringService {

    @Override
    public int amountOfAllSymbols(String text){
        return text.length();
    }

    @Override
    public Map<Character,Integer> sortedOrderOfChars(String text){
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<text.length(); i++){
            //перебрать мапу, узнать есть ли такой символ либо его нужно добавить
            if(map.containsKey(text.charAt(i))){
                Integer count = map.getOrDefault(text.charAt(i),1);
                map.put(text.charAt(i), count+1);
            }
            else{
                map.put(text.charAt(i),1);
            }
        }

        map = map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        return map;
    }


    @Override
    public int amountOfAllWords(String text){
        String [] words = text.split("\\s+");
        for(int i=0; i<words.length;i++){
            if(words[i].contains(","))
                words[i] = words[i].replace(",", "");
            else if(words[i].contains("."))
                words[i] = words[i].replace(".", "");

        }
//        for(int i=0; i<words.length; i++){
//            System.out.print(words[i]+"||");
//        }
        return words.length;
    }


    @Override
    public Map<String,Integer> sortedOrderOfWords(String text){
        Map<String, Integer> map = new HashMap<>();
        String [] words = text.split("\\s+");
        for(int i=0; i<words.length;i++){
            if(words[i].contains(",")) {
                words[i] = words[i].replace(",", "");
            }
            else if(words[i].contains(".")){
                words[i] =  words[i].replace(".", "");
            }
        }
        for(int i=0; i<words.length; i++){
            //перебрать мапу, узнать есть ли такой символ либо его нужно добавить
            if(map.containsKey(words[i])){
                Integer count = map.getOrDefault(words[i], 1);
                map.put(words[i], count+1);
            }
            else{
                map.put(words[i], 1);
            }
        }
        map = map
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        return map;
    }

    @Override
    public String reverseOfText (String text){
        String [] sentences = text.split("\\.");
        for(int i=0; i<sentences.length;i++){
            if(sentences[i].contains(","))
                sentences[i] = sentences[i].replace(",", "");

            else if(sentences[i].contains("."))
                sentences[i] =  sentences[i].replace(".", "");
        }
        String reversed ="";

        for(int i=0; i<sentences.length; i++){
            reversed+="Предложение"+(i+1)+"   ";
            String temp = sentences[i];
            String [] words = temp.split("\\s");

            String [] result = new String [words.length];
            for(int j=0; j<words.length; j++){
                result[j] = words[words.length-j-1];
            }
            for(String str : result){
                reversed+=str+" ";
            }
            reversed+=".\n";
        }
        return reversed;
    }



}
