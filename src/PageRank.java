class PageRank {

    static void rank(Article... articles) {
        for (Article a : articles) {
            System.out.println(a.getTitle());
        }
    }
}
