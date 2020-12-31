package com.example.hinge.data;

import com.example.hinge.R;

public class People {
    protected Matches lisa = new Matches();
    protected Matches tzuyu = new Matches();

    public Matches getLisa() {
        if (lisa.getName() == null) {
            lisa.setName("Lisa");
            lisa.setImageTitles(new String[]{
                    "Looking for an android developer",
                    "When I see an Android developer",
                    "When I know you got an iPhone",
                    "We will install our app in here.",
                    "My cool pic with my cool phone.",
                    "My ex build Brawl Stars."
            });
            lisa.setImages(new int[]{
                    R.drawable.lisa,
                    R.drawable.lisatwo,
                    R.drawable.lisa_2,
                    R.drawable.lisa_4,
                    R.drawable.lisa_5,
                    R.drawable.lisa_6,
            });
            lisa.setTextContentTitles(new String[]{
                    "The way to win me over is",
                    "I'm looking for",
                    "I'll fall for you if",
            });
            lisa.setTextContent(new String[]{
                    "By showing me the code.",
                    "A cool android developer who can implement MVVM architecture flawlessly.",
                    "You complete 6 months of masai school with 100% attendance and assignment submission.",
            });
            lisa.setAge(23);
            lisa.setGender("Woman");
            lisa.setReligion("Buddhist");
            lisa.setHeight("5' 6\"");
            lisa.setLocation("Buriram");
            lisa.setEthnicity("South Asian");
            lisa.setEducation("Praphamontree");
            lisa.setCountry("Thailand");
        }
        return lisa;
    }

    public Matches getTzuyu() {
        if (tzuyu.getName() == null) {
            tzuyu.setName("Tzuyu");
            tzuyu.setImageTitles(new String[]{
                    "In search for an android developer",
                    "Android developer's are true angles",
                    "When I see iPhone users",
                    "We will install our app in here.",
                    "To all android developers out there.",
                    "My cool pic."
            });
            tzuyu.setImages(new int[]{
                    R.drawable.tzuyu_1,
                    R.drawable.tzuyu_2,
                    R.drawable.tzuyu_3,
                    R.drawable.tzuyu_4,
                    R.drawable.tzuyu_5,
                    R.drawable.tzuyu_6,
            });
            tzuyu.setTextContentTitles(new String[]{
                    "I wont't shut up about",
                    "The key to my heart is",
                    "The thing you should know about me is",
            });
            tzuyu.setTextContent(new String[]{
                    "how great google is.",
                    "clean code.",
                    "i only use a single activity in my apps.",
            });
            tzuyu.setAge(21);
            tzuyu.setGender("Woman");
            tzuyu.setReligion("Buddhist");
            tzuyu.setHeight("5' 7\"");
            tzuyu.setLocation("Tainan");
            tzuyu.setEthnicity("South Asian");
            tzuyu.setEducation("Hanlim");
            tzuyu.setCountry("Taiwan");
        }
        return tzuyu;
    }

}
