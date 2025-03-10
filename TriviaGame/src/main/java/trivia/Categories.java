package trivia;

import java.io.File;

enum Categories {
    POP("Pop", "./Questions/Pop.questions"),
    SCIENCE("Science", "./Questions/Science.questions"),
    SPORTS("Sports", "./Questions/Sports.questions"),
    ROCK("Rock","./Questions/ROck.questions"),
    ;

    private final String stringValue;
    private final String fileNameValue;

    Categories(final String string, final String file) {
        stringValue = new String(string);
        fileNameValue = new String(file);
    }

    public String toString(){
        return stringValue;
    }

    public String getFileName(){
        return fileNameValue;
    }
}
