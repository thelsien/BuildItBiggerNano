package com.example;

public class JokeProvider {
    private static JokeProvider instance;

    private JokeProvider() {

    }

    public static JokeProvider getInstance() {
        if (instance == null) {
            instance = new JokeProvider();
        }

        return instance;
    }

    public String getJoke() {
        return "This is NOT a joke! Return something better here later.";
    }
}
