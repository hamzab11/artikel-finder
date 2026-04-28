package com.example.artikelfinder;

import java.util.LinkedHashMap;
import java.util.Map;

public class Rules {
    private final Map<String, String> endings = new LinkedHashMap<>();

    public Rules() {
        endings.put("schaft", "die");
        endings.put("heit", "die");
        endings.put("keit", "die");
        endings.put("ung", "die");
        endings.put("tion", "die");
        endings.put("chen", "das");
        endings.put("lein", "das");
        endings.put("ment", "das");
        endings.put("ismus", "der");
        endings.put("ling", "der");
        endings.put("er", "der");
        endings.put("e", "die");
    }

    public String findArticle(String noun) {
        noun = noun.toLowerCase();

        for (Map.Entry<String, String> rule : endings.entrySet()) {
            if (noun.endsWith(rule.getKey())) {
                return rule.getValue();
            }
        }

        return "unknown";
    }
}