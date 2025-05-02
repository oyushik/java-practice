package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    List<Publication> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Publication item) {
        items.add(item);
        System.out.println("출판물을 추가했습니다: \n" + item.toString());
    }

    public boolean removeItem(String title) {
        Iterator<Publication> iterator = items.iterator();
        boolean isFound = false;
        while (iterator.hasNext()) {
            Publication item = iterator.next();
            if (item.getTitle().equals(title)) {
                iterator.remove();
                isFound = true;
                System.out.println("출판물을 제거했습니다: " + title);
                break;
            }
        }
        if (!isFound) {
            System.out.println("해당 제목의 출판물을 찾을 수 없습니다: " + title);
        }
        return isFound;
    }

    public int calculateTotalPrice() {
        int total = 0;
        for (Publication item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public double calculateDiscountedPrice() {
        double totalDiscounted = 0;
        for (Publication item : items) {
            double discountedPrice = item.getPrice();
            if (item instanceof Magazine) {
                discountedPrice *= 0.90;
            } else if (item instanceof Novel) {
                discountedPrice *= 0.85;
            } else if (item instanceof ReferenceBook) {
                discountedPrice *= 0.80;
            }
            totalDiscounted += discountedPrice;
        }
        return totalDiscounted;
    }

    public void displayCart() {
        System.out.println("\n==== 장바구니 내용 ====");
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
            return;
        }

        DecimalFormat formatter = new DecimalFormat("#,###");
        for (int i = 0; i < items.size(); i++) {
            Publication item = items.get(i);
            System.out.printf("%d. %s %s%s%n",
                    i + 1,
                    item.getTitle(),
                    item.getFormattedTypeAndInfo(),
                    item.getFormattedCommonDetails()
            );
        }

        int totalPrice = calculateTotalPrice();
        double discountedPrice = calculateDiscountedPrice();

        System.out.println("------------------------------------");
        System.out.println("총 가격: " + formatter.format(totalPrice) + "원");
        System.out.println("할인 적용 가격: " + formatter.format(discountedPrice) + "원");
        System.out.println("====================================");
    }

    public void printStatistics() {
        System.out.println("\n==== 장바구니 통계 (타입별 수량) ====");
        Map<String, Integer> typeCounts = new HashMap<>();

        for (Publication item : items) {
            String type = "기타";
            if (item instanceof Novel) {
                type = "소설";
            } else if (item instanceof Magazine) {
                type = "잡지";
            } else if (item instanceof ReferenceBook) {
                type = "참고서";
            }
            typeCounts.put(type, typeCounts.getOrDefault(type, 0) + 1);
        }

        if (typeCounts.isEmpty()) {
            System.out.println("장바구니에 항목이 없습니다.");
        } else {
            for (Map.Entry<String, Integer> entry : typeCounts.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + "개");
            }
        }
        System.out.println("=====================================");
    }
}