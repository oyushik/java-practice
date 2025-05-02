package mylab.book.entity;

public class ReferenceBook extends Publication {
    private String field;

    public ReferenceBook(String title, String publishDate, int page, int price, String field) {
        super(title, publishDate, page, price);
        this.field = field;
    }

    public String getField() {
        return field;
    }

    @Override
    public String getFormattedTypeAndInfo() {
        return String.format("[참고서] 분야:%s", this.field);
    }

    @Override
    public String toString() {
        return "ReferenceBook{" +
                "field='" + field + '\'' +
                ", " + super.toString() +
                '}';
    }
}