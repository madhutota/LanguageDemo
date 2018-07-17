package tudo.com.languagedemo;

public class LanguageObject {

    String languageName;
    int position;

    public LanguageObject(String languageName, int position) {
        this.languageName = languageName;
        this.position = position;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
