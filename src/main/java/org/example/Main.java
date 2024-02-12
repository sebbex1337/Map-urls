package org.example;

import java.util.ArrayList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("<div>");
        words.add("Hvad");
        words.add("<p>");
        words.add("Fonseca");

        ArrayList<String> urls = new ArrayList<>();
        urls.add("https://www.dr.dk");
        urls.add("https://www.ekstrabladet.dk");
        urls.add("https://www.bt.dk");

        UrlReader urlReader = new UrlReader();
        Map<String, Integer> mapWords = urlReader.readUrl("https://www.dr.dk", words);
        System.out.println(mapWords);

        Map<String, Map<String, Integer>> mappedUrls = urlReader.mapUrls(urls, words);
        System.out.println(mappedUrls);
    }
}