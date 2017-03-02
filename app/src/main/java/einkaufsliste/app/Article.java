package einkaufsliste.app;

public class Article {

    private int articleId;
    private String articleName;
    private int articleAmount;
    private Long articleTimeAdded;

    /**
     * Default constructor
     *
     * @param
     */
    public Article() {
        this.articleId = articleId;
        this.articleName = articleName;
        this.articleAmount = articleAmount;
        this.articleTimeAdded = articleTimeAdded;
    }

    /**
     * Getter & Setter.
     * @param articleId
     */
    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }
    public int getArticleId() {
        return articleId;
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
     * @param articleAmount
     */
    public void setArticleAmount(int articleAmount) {
        this.articleAmount = articleAmount;
    }

    public int getArticleAmount() {
        return articleAmount;
    }

    /**
     * Getter & Setter.
     * @param articleTimeAdded
     */
    public void setArticleTimeAdded(Long articleTimeAdded) {
        this.articleTimeAdded = articleTimeAdded;
    }
    public Long getArticleTimeAdded() {
        return articleTimeAdded;
    }
}
