package com.example;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class JokeProvider {
    private static JokeProvider instance;
    private List<String> jokesList;
    private Random random;

    private JokeProvider() {
        jokesList = new ArrayList<>();

        jokesList.add("Q: What does a bum call a dumpster.\n\nA: Bed and Breakfast.");
        jokesList.add("I think if you go to jail for something you didn't do, you should get credit towards another crime.");
        jokesList.add("Q: What's the definition of a Yankee?\nA: Same thing as a \"quickie,\" only you do it yourself.");
        jokesList.add("A young wife, her boorish husband and a young good looking sailor were shipwrecked on an island. One morning, the sailor climbed a tall coconut tree and yelled, \"Stop making love down there!\"\n" +
                "\"What's the matter with you?\" the husband said when the sailor climbed down. '\"We weren't making love.\"\n" +
                "\"Sorry,\" said the sailor, \"From up there it looked like you were.\"\n" +
                "Every morning thereafter, the sailor scaled the same tree and yelled the same thing. Finally the husband decided to climb the tree and see for himself. With great difficulty, he made his way to the top.\n" +
                "The husband says to himself, \"By golly he's right! It DOES look like they're making love down there!\"");
        jokesList.add("Yo' Mama is so fat, she got baptized at Sea World.");
        jokesList.add("Three guys are drinking in a bar when a drunk comes in, staggers up to them, and points at the guy in the middle, shouting, \"Your mom's the best lay in town.\"\n" +
                "Everyone expects a fight, but the guy ignores him and the drunk wanders off and stands at the far end of the bar.\n" +
                "Ten minutes later, the drunk comes back, points to the same guy, and says, \"I just screwed your mom, and it was swe-e-et!\"\n" +
                "Again the guy refuses to take the bait, and the drunk wanders off.\n" +
                "Ten minutes later he comes back and announces, \"Your mom even let me...\"\n" +
                "Finally the guy interrupts: \"Go home, Dad - you're drunk!\"");
        jokesList.add("Four blondes drive to a bar in their old pickup truck. Three sit in the cab, and one sits in the bed of the truck.\n" +
                "The three blondes go into the bar and order a round of shots. Almost an hour later, the fourth blonde finally joins them.\n" +
                "\"Where have you been?\" they ask.\n" +
                "She responds, \"Well, you all forgot to open the tailgate!\"");
        jokesList.add("Albert Einstein used to go to dinners where he was invited to give a speech. One day, on his way to one of those dinners, he told his chauffeur (who looked exactly like him) that he was dead tired of giving the same speech, dinner after dinner.\n" +
                "\"Well,\" said the chaffeur, \"I've got a good idea. Why don't I give the speech since I've heard it so many times?'' So Albert's chauffeur gave the speech perfectly and even answered a few questions. Then, a professor stood up and asked him a really tough question about anti-matter which the chauffeur couldn't answer\n" +
                "\"Sir, the answer to your question is so easy that I'll let my chauffeur answer it!\"");
        jokesList.add("Q: Why did the blind blonde cross the road?\n" +
                "\n" +
                "A: She was following her seeing-eye chicken.");

        random = new Random(Calendar.getInstance().getTimeInMillis());
    }

    public static JokeProvider getInstance() {
        if (instance == null) {
            instance = new JokeProvider();
        }

        return instance;
    }

    public String getJoke() {
        int r = random.nextInt(jokesList.size());
        return jokesList.get(r);
    }
}
