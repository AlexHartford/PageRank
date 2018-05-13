class Article {

    private String title;
    private Article[] citations;

    Article(String title, Article... citations) {
        this.title = title;
        this.citations = citations;
    }

    String getTitle() {
        return title;
    }

    Article[] getCitations() {
        return citations;
    }
}
