import java.util.ArrayList;
import java.util.Arrays;

class Article {

    private String title;
    private Article[] citations;
    private double rank;

    Article(String title, Article... citations) {
        this.title = title;
        this.citations = citations;
        this.rank = 0;
    }

    String getTitle() {
        return title;
    }

    ArrayList<Article> getCitations() {
        return new ArrayList<>(Arrays.asList(citations));
    }

    double getNumberOfCitations() {
        return (double) citations.length;
    }

    void setRank(double rank) {
        this.rank = rank;
    }

    double getRank() {
        return rank;
    }
}
