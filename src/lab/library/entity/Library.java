package lab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books;
    private String name;

    public Library(String name) {
        books = new ArrayList<>();
        this.name = name;
    }

    private boolean isBooksListAvailable() {
        if (books == null) {
            System.out.println("도서 리스트를 불러오는 데에 실패했습니다.");
            return false;
        }
        return true;
    }

    public void showLibrayStatus() {
        System.out.printf(
                "\n도서관 현재 상태: \n" +
                "대출 가능 도서 수: %d\n" +
                "대출 중인 도서 수: %d\n",
                getTotalBooksCount(), getBorrowedBooksCount()
                ).println();
    }

    public void addBook(Book newBook) {
        books.add(newBook);
        System.out.printf("도서가 추가되었습니다: %s", newBook.getTitle()).println();
    }

    public Book findBookByTitle(String title) {
        if (isBooksListAvailable()) {
            for (Book book : books) {
                if (book.getTitle().equals(title)) {
                    return book;
                }
            }
        }
        return null;
    }

    public Book findBookByAuthor(String author) {
        if (isBooksListAvailable()) {
            for (Book book : books) {
                if (book.getAuthor().equals(author)) {
                    return book;
                }
            }
        }
        return null;
    }

    public Book findBookByIsbn(String isbn) {
        if (isBooksListAvailable()) {
            for (Book book : books) {
                if (book.getIsbn().equals(isbn)) {
                    return book;
                }
            }
        }
        return null;
    }

    public boolean checkOutBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("입력한 isbn에 해당하는 도서가 없습니다.");
            return false;
        }

        if (book.checkOut()) {
            System.out.printf("도서 대출 성공!\n" +
                              "대출된 도서 정보:\n" +
                              "책 제목: %s\t저자: %s\tISBN: %s\t출판년도: %d\t대출 가능 여부: %b",
                    book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublishYear(), book.getIsAvailable()
                    ).println();
            return true;
        } else {
            System.out.println("해당 도서는 현재 대출 중입니다.");
            return false;
        }
    }

    public boolean returnBook(String isbn) {
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("입력한 isbn에 해당하는 도서가 없습니다.");
            return false;
        }

        if (book.getIsAvailable() == false) {
            book.returnBook();
            System.out.printf("도서가 반납되었습니다: %s", book.getTitle()).println();
            return true;
        } else {
            System.out.println("해당 도서는 현재 반납되어 있습니다.");
            return false;
        }
    }

    public List<Book> getTotalBooks() {
        if (isBooksListAvailable()) {
            return books;
        }
        return null;
    }

    public List<Book> getAvailableBooks() {
        if (isBooksListAvailable()) {
            List<Book> availableBooksList = new ArrayList<>();

            for (Book book : books) {
                if (book.getIsAvailable()) {
                    availableBooksList.add(book);
                    System.out.printf(
                            "책 제목: %s\t저자: %s\tISBN: %s\t출판년도: %d\t대출 가능 여부: %b",
                            book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublishYear(), book.getIsAvailable()
                    ).println();
                }
            }
            return availableBooksList;
        }
        return null;
    }

    public int getTotalBooksCount() {
        if (isBooksListAvailable()) {
            return books.size();
        }
        return 0;
    }

    public int getAvailableBooksCount() {
        if (isBooksListAvailable()) {
            List<Book> availableBooksList = new ArrayList<>();

            for (Book book : books) {
                if (book.getIsAvailable()) {
                    availableBooksList.add(book);
                }
            }
            return availableBooksList.size();
        }
        return 0;
    }

    public int getBorrowedBooksCount() {
        if (isBooksListAvailable()) {
            List<Book> borrowedBooksList = new ArrayList<>();

            for (Book book : books) {
                if (book.getIsAvailable()) {
                    borrowedBooksList.add(book);
                }
            }
            return borrowedBooksList.size();
        }
        return 0;
    }
}
