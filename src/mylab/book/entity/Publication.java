package mylab.book.entity;

public abstract class Publication {
    private String title;
    private String publishDate;
    private int page;
    private int price;

    public Publication(String title, String publishDate, int page, int price) {
        this.title = title;
        this.publishDate = publishDate;
        this.page = page;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public int getPage() {
        return page;
    }

    public abstract String getFormattedTypeAndInfo();

    public String getFormattedCommonDetails() {
        return String.format(", %d쪽, %d원, 출판일: %s", this.page, this.price, this.publishDate);
    }

    @Override
    public String toString() {
        return "Publication{" +
                "title='" + title + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", page=" + page +
                ", price=" + price +
                '}';
    }
}