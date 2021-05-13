package jacopo;

import java.util.*;
import java.io.*;

/**
 * Created on:  May 05, 2021
 * Questions:
 * - today's date
 * - [order1, order2, ...., ordern]
 * - item is available
 * - ship the order in a few packages as possible
 * - the order has to be shipped within 3 days
 * <p>
 * - orders = [item1, time1], [item2, time2],.... [itemn,timen]]
 * - availability = [item1, timex], [item2, timey].... ]
 * <p>
 * list of list of items to be shipped: [[item1][item2]], [[item3]], [][item4]]
 * <p>
 * LocalDateTime : May 1 2021 7.21pm
 * <p>
 * Time: t * n
 * shipped = {}
 * shipping = []
 * <p>
 * LocalDateTime start = time1, end = timen.plusDays(3);
 * <p>
 * May 1st 3 PM to May 3th 9 PM
 * <p>
 * 1st May till 11:59 PM
 * 2nd May till 11:59 PM
 * 3rd May till 11:59 PM
 * 4th May till 11:59 PM
 * 5th May till 11:59 PM
 * 6th May till 09:00 PM
 * <p>
 * for curent_time in range(time1, timen+3):
 *      currentday_shipping = []
 *      for item, order_time in orders:
 *          if order_time > curent_time: break
 *          if shipped.contains(item): continue
 *          else:
 *              available_time = availability.get(item)
 *              if order_time <= curent_time <= order_time+3 && available_time <= curent_time:
 *              shipped.add(item)
 *              currentday_shipping.add(item)
 *       if len(currentday_shipping) > 0:
 *          shipping.add(currentday_shipping)
 * return shipping
 * <p>
 * [item1, time1], [item2, time2]
 * i
 * timex
 * <p>
 * [timex, timex+3] = [item1, item2]
 * <p>
 * taken items =
 * <p>
 * map1 = [item1, timex], [item2, timex+1]
 * map2 = time : list[item]
 */

public class OAQ1 {

    public static void main(String[] args) {

    }
}
