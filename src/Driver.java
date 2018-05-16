import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Driver {

    public static void main(String[] args) {
        times(0, 1);
//        PageRank.rank(generateArticleData());
    }

    /**
     * Grabs a portion of the data array between provided indices
     *
     * @param startIndex int desired index to start at
     * @param endIndex   int desired index to end at
     * @return Article array within indices
     */
    private static Article[] partialData(int startIndex, int endIndex) {
        return Arrays.copyOfRange(generateRandomArticleData(), startIndex, endIndex);
    }

    /**
     * Generate times for partial data from start index, incrementing till end of array
     *
     * @param startIndex int desired index to start at
     * @param increment  int number to increment by
     */
    private static void times(int startIndex, int increment) {
        ArrayList<Long> times = new ArrayList<>();
        for (int i = 0; i < generateRandomArticleData().length; i += increment) {
            times.add(PageRank.rank(partialData(startIndex, i + increment)));
        }
        for (long time : times) {
            System.out.println(time);
        }
    }

    /**
     * Highest-Rank Article should be index 0: https://arxiv.org/abs/1604.07316
     *
     * @return array of articles based on actual articles on google scholar
     */
    private static Article[] generateArticleData() {
        Article[] articles = new Article[8];

//        articles[0] = new Article("A");
//        articles[1] = new Article("B", articles[0], articles[2]);
//        articles[2] = new Article("C", articles[0]);
//        articles[3] = new Article("D", articles[0], articles[1], articles[2]);


        articles[0] = new Article("End to end learning for self-driving cars");
        articles[1] = new Article("Eyeriss...", articles[0]);
        articles[2] = new Article("Towards evaluating the robustness of neural networks", articles[0]);
        articles[3] = new Article("Deep predictive coding networks...", articles[0]);
        articles[4] = new Article("End-to-end learning of driving models...", articles[0]);

        articles[5] = new Article("Backpropagation for energy-efficient neuromorphic computing", articles[1]);
        articles[6] = new Article("Minerva...", articles[1]);
        articles[7] = new Article("Cnvlutin", articles[1]);


        return articles;
    }

    /**
     * Generate random article data with random citations
     * Used for testing time complexity of algorithm
     *
     * @return Article array with random data
     */
    private static Article[] generateRandomArticleData() {
        Article[] articles = new Article[1000];

        for (int i = 0; i < articles.length; i++) {
            Random rand = new Random();

            int m = rand.nextInt(100) + 1;
            Article[] articlesCitations = new Article[m];
            for (int j = 0; j < m; j++) {
                int citation = rand.nextInt(1000);
                articlesCitations[j] = articles[citation];
            }
            articles[i] = new Article(Integer.toString(i), articlesCitations);
        }

        return articles;
    }
}
