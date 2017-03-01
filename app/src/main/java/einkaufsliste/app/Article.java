package einkaufsliste.app;

public class Article {

    private String articleName;
    private double articlePrice;
    private double articleAmount;

    /**
     * Default constructor
     *
     * @param name
     */
    public Article(String name) {
        this.articleName = name;
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
     * @param price
     */
    public void setArticlePrice(double price) {
        this.articlePrice = price;
    }
    public double getArticlePrice() {
        return articlePrice;
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
