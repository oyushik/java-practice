package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ManageBook {

    private static final String ITEM_TO_MODIFY = "작별하지않는다"; // 검색어

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        shoppingCart.addItem(new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"));
        shoppingCart.addItem(new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"));
        shoppingCart.addItem(new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"));
        shoppingCart.addItem(new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"));
        shoppingCart.addItem(new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"));
        shoppingCart.addItem(new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"));
        shoppingCart.addItem(new Novel(ITEM_TO_MODIFY, "2021-09-09", 332, 15120, "한강", "장편소설"));

        shoppingCart.displayCart();

        System.out.println("\n==== 가격 변경 ====");

        Publication targetItem = null;
        for (Publication item : shoppingCart.items) {
            if (ITEM_TO_MODIFY.equals(item.getTitle())) {
                targetItem = item;
                break;
            }
        }

        if (targetItem != null) {
            int originalPrice = targetItem.getPrice();
            int newPrice = 12096;
            targetItem.setPrice(newPrice);
            int difference = originalPrice - newPrice;
            System.out.println(targetItem.getTitle() + " 변경 전 가격: " + originalPrice + "원");
            System.out.println(targetItem.getTitle() + " 변경 후 가격: " + newPrice + "원");
            System.out.println("차액: " + difference + "원");
        } else {
            System.out.println("'" + ITEM_TO_MODIFY + "' 항목을 장바구니에서 찾을 수 없습니다.");
        }

        StatisticsAnalyzer statsAnalyzer = new StatisticsAnalyzer();
        Publication[] publicationsArray = shoppingCart.items.toArray(new Publication[0]);
        statsAnalyzer.printStatistics(publicationsArray);
    }
}