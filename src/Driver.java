public class Driver {

    public static void main(String[] args) {
        PageRank.rank(generateArticleData());
    }

    /**
     * Highest-Rank Article should be index 0: https://arxiv.org/abs/1604.07316
     * @return array of articles based on actual articles on google scholar
     */
    private static Article[] generateArticleData() {
        Article[] articles = new Article[10];

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
}
