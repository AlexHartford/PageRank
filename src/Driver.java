public class Driver {

    public static void main(String[] args) {
        Article a1 = new Article("Test");
        Article a2 = new Article("Test2", a1);
        Article a3 = new Article("Test3");
        Article a4 = new Article("Test4", a2, a3);

        PageRank.rank(a1, a2, a3, a4);
    }
}
