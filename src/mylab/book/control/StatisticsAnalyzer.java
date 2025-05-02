package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatisticsAnalyzer {

    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "소설";
        } else if (pub instanceof Magazine) {
            return "잡지";
        } else if (pub instanceof ReferenceBook) {
            return "참고서";
        } else {
            return "기타";
        }
    }

    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Double> totalPrices = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();

        if (publications != null) {
            for (Publication pub : publications) {
                String type = getPublicationType(pub);
                totalPrices.put(type, totalPrices.getOrDefault(type, 0.0) + pub.getPrice());
                counts.put(type, counts.getOrDefault(type, 0) + 1);
            }
        }

        Map<String, Double> averagePrices = new HashMap<>();
        for (Map.Entry<String, Double> entry : totalPrices.entrySet()) {
            String type = entry.getKey();
            double total = entry.getValue();
            int count = counts.get(type);
            if (count > 0) {
                averagePrices.put(type, total / count);
            } else {
                averagePrices.put(type, 0.0);
            }
        }
        return averagePrices;
    }

    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> counts = new HashMap<>();
        int totalCount = 0;

        if (publications != null) {
            for (Publication pub : publications) {
                String type = getPublicationType(pub);
                counts.put(type, counts.getOrDefault(type, 0) + 1);
                totalCount++;
            }
        }

        Map<String, Double> distribution = new HashMap<>();
        if (totalCount > 0) {
            for (Map.Entry<String, Integer> entry : counts.entrySet()) {
                distribution.put(entry.getKey(), (double) entry.getValue() / totalCount * 100);
            }
        }
        return distribution;
    }

    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int countInYear = 0;
        int totalCount = 0;

        if (publications != null) {
            for (Publication pub : publications) {
                totalCount++;
                if (pub.getPublishDate() != null && pub.getPublishDate().startsWith(year)) {
                    countInYear++;
                }
            }
        }

        if (totalCount > 0) {
            return (double) countInYear / totalCount * 100;
        } else {
            return 0.0;
        }
    }

    public void printStatistics(Publication[] publications) {
        System.out.println("\n===== 출판물 통계 분석 =====");
        if (publications == null || publications.length == 0) {
            System.out.println("분석할 출판물 데이터가 없습니다.");
            System.out.println("=============================");
            return;
        }

        DecimalFormat priceFormatter = new DecimalFormat("#,###");
        DecimalFormat percentFormatter = new DecimalFormat("0.00");

        System.out.println("1. 타입별 평균 가격:");
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        if (avgPrices.isEmpty()) {
            System.out.println("   데이터 부족.");
        } else {
            for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
                System.out.println("   - " + entry.getKey() + ": " + priceFormatter.format(entry.getValue()) + "원");
            }
        }

        System.out.println("\n2. 출판물 유형 분포:");
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        if (distribution.isEmpty()) {
            System.out.println("   데이터 부족.");
        } else {
            for (Map.Entry<String, Double> entry : distribution.entrySet()) {
                System.out.println("   - " + entry.getKey() + ": " + percentFormatter.format(entry.getValue()) + "%");
            }
        }

        System.out.println("\n3. 2007년에 출판된 출판물 비율:");
        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.println("   " + percentFormatter.format(ratio2007) + "%");

        System.out.println("=============================");
    }
}