import java.util.PriorityQueue;

/**
 * Created on:  Jan 14, 2021
 * Questions: https://aonecode.com/amazon-online-assessment-five-star-sellers
 */

public class FiveStarSellers {

    public static void main(String[] args) {
        System.out.println(fiveStarReviews(new int[][]{{4, 4}, {1, 2}, {3, 6}}, 77));
    }

    public static int fiveStarReviews(int[][] productRatings, int ratingsThreshold) {
        PriorityQueue<Product> pq = new PriorityQueue<>((p1, p2) -> Double.compare(p2.afterChange, p1.afterChange));
        double current = 0;
        for (int[] product : productRatings) {
            pq.add(new Product(product[0], product[1]));
            current += (double) product[0] / product[1];
        }
        int change = 0, n = productRatings.length;
        current /= n;
        while (current * 100 < ratingsThreshold) {
            Product poll = pq.poll();
            current += poll.overAllContribution(n);
            change++;
            pq.add(new Product(poll.count + 1, poll.total + 1));
        }
        return change;
    }

    static class Product {
        int count, total;
        double afterChange;

        public Product(int count, int total) {
            this.count = count;
            this.total = total;
            setNewReviewChange();
        }

        private void setNewReviewChange() {
            double curPer = (double) count / total;
            double newPer = (double) (count + 1) / (total + 1);
            this.afterChange = newPer - curPer;
        }

        private double overAllContribution(int count) {
            return (afterChange / count);
        }
    }
}
