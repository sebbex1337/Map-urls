package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UrlReader {
    public Map<String, Integer> readUrl(String strUrl, List<String> words) {
        Map<String, Integer> mapWords = new HashMap<>();
        for (String ss: words) {
            mapWords.put(ss, 0);
        }

        try {
            URL url = new URL(strUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            while (line != null) {
                for (String word: words) {
                    if (line.contains(word)) {
                        int i = mapWords.get(word);
                        i++;
                        mapWords.put(word, i);
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapWords;
    }

    public Map<String, Map<String, Integer>> mapUrls(ArrayList<String> urls, ArrayList<String> words) {
        Map<String, Map<String, Integer>> mappedUrls = new HashMap<>();

        for (String url: urls) {
            mappedUrls.put(url, readUrl(url, words));

        }

        return mappedUrls;
    }
}
