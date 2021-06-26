package biweekly.biweekly55;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created on:  Jun 26, 2021
 * Ref: https://leetcode.com/contest/biweekly-contest-55/problems/design-movie-rental-system/
 */

public class DesignMovieRentalSystem {

    public static void main(String[] args) {
        System.out.println("********************** Q1 ******************************");
        MovieRentingSystem movieRentingSystem = new MovieRentingSystem(3, new int[][]{{0, 1, 5}, {0, 2, 6}, {0, 3, 7}, {1, 1, 4}, {1, 2, 7}, {2, 1, 5}});
        System.out.println(movieRentingSystem.search(1));  // return [1, 0, 2], Movies of ID 1 are unrented at shops 1, 0, and 2. Shop 1 is cheapest; shop 0 and 2 are the same price, so order by shop number.
        movieRentingSystem.rent(0, 1); // Rent movie 1 from shop 0. Unrented movies at shop 0 are now [2,3].
        movieRentingSystem.rent(1, 2); // Rent movie 2 from shop 1. Unrented movies at shop 1 are now [1].
        System.out.println(movieRentingSystem.report());// return [[0, 1], [1, 2]]. Movie 1 from shop 0 is cheapest, followed by movie 2 from shop 1.
        movieRentingSystem.drop(1, 2); // Drop off movie 2 at shop 1. Unrented movies at shop 1 are now [1,2].
        System.out.println(movieRentingSystem.search(2));  // return [0, 1]. Movies of ID 2 are unrented at shops 0 and 1. Shop 0 is cheapest, followed by shop 1.

        System.out.println("********************** Q2 ******************************");
        movieRentingSystem = new MovieRentingSystem(3, new int[][]{{0, 1, 3}, {0, 5, 3}, {0, 7, 3}, {0, 6, 3}, {0, 2, 3}, {0, 3, 3}, {0, 4, 3}, {0, 8, 3}});
        movieRentingSystem.rent(0, 1);
        System.out.println(movieRentingSystem.report());
        movieRentingSystem.rent(0, 4);
        System.out.println(movieRentingSystem.report());
        movieRentingSystem.rent(0, 3);
        System.out.println(movieRentingSystem.report());
        movieRentingSystem.rent(0, 2);
        movieRentingSystem.rent(0, 6);
        movieRentingSystem.rent(0, 7);
        System.out.println(movieRentingSystem.report());
    }

    static class MovieRentingSystem {
        int n, limit = 5;
        Map<String, Entry> entryMap = new HashMap<>();
        Map<Integer, TreeSet<Entry>> available = new HashMap<>();
        Comparator<Entry> order = (e1, e2) -> e1.price == e2.price ? (e1.shop == e2.shop ? Integer.compare(e1.movie, e2.movie) : Integer.compare(e1.shop, e2.shop)) : Integer.compare(e1.price, e2.price);
        //                TreeSet<Entry> rented = new TreeSet<>(order);
        Set<Entry> rented = new HashSet<>();

        public MovieRentingSystem(int n, int[][] entries) {
            this.n = n;
            for (int[] entry : entries) {
                Entry entryObj = new Entry(entry[0], entry[1], entry[2]);
                entryMap.put(getKey(entryObj), entryObj);
                addAvailability(entryObj);
            }
        }

        void addAvailability(Entry entry) {
            available.computeIfAbsent(entry.movie, val -> new TreeSet<>(order)).add(entry);
        }

        String getKey(Entry entry) {
            return getKey(entry.shop, entry.movie);
        }

        String getKey(int shop, int movie) {
            return shop + " -> " + movie;
        }

        public List<Integer> search(int movie) {
            return available.getOrDefault(movie, new TreeSet<>(order)).stream().limit(limit).map(entry -> entry.shop).collect(Collectors.toList());
        }

        //            Time: Log m, where m is number of available Entries for the movie.
        public void rent(int shop, int movie) {
            Entry entry = entryMap.get(getKey(shop, movie));
            if (entry == null) return;
            available.get(movie).remove(entry);
            rented.add(entry);
        }

        //            Time: Log m, where m is number of available Entries for the movie.
        public void drop(int shop, int movie) {
            Entry entry = entryMap.get(getKey(shop, movie));
            if (entry == null) return;
            rented.remove(entry);
            addAvailability(entry);
        }

        public List<List<Integer>> report() {
//            Loop though all the rented items and sort those by the order, and limit only 5.
            return rented.stream().sorted(order).limit(limit).map(entry -> List.of(entry.shop, entry.movie)).collect(Collectors.toList());
        }

        static class Entry {
            int shop, movie, price;

            Entry(int shop, int movie, int price) {
                this.shop = shop;
                this.movie = movie;
                this.price = price;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Entry entry = (Entry) o;

                if (shop != entry.shop) return false;
                if (movie != entry.movie) return false;
                return price == entry.price;
            }

            @Override
            public int hashCode() {
                int result = shop;
                result = 31 * result + movie;
                result = 31 * result + price;
                return result;
            }

            @Override
            public String toString() {
                return "Entry{" +
                        "shop=" + shop +
                        ", movie=" + movie +
                        ", price=" + price +
                        '}';
            }
        }
    }
}
