package einkaufsliste.app;

public class Article {

    private String articleName;
    private double articleAmount;
    private double articleTimeAdded;

    /**
     * Default constructor
     *
     * @param
     */
    public Article() {
        this.articleName = articleName;
        this.articleAmount = articleAmount;
        this.articleTimeAdded = articleTimeAdded;
    }

    /**
     * Getter & Setter.
     * @param name
     */
    public void setArticleName(String name) {
        this.articleName = name;
    }
    public String getArticleName() {
        return articleName;
    }

    /**
     * Getter & Setter.
     * @param articleTimeAdded
     */
    public void setArticleTimeAdded(double articleTimeAdded) {
        this.articleTimeAdded = articleTimeAdded;
    }
    public double getArticleTimeAdded() {
        return articleTimeAdded;
    }

    /**
     * Getter & Setter.
     * @param amount
     */
    public void setArticleAmount(double amount) {
        this.articleAmount = amount;
    }
    public double getArticleAmount() {
        return articleAmount;
    }
}
