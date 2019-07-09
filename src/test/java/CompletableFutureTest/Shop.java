/**
 * Description:
 * User: daipeng
 * Date: 2019-06-25 17:20
 * Project:CodeSnippet
 */
package CompletableFutureTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import net.bytebuddy.asm.Advice;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
@Data
@AllArgsConstructor
public class Shop {
    private String name;
    public String getPrice(String product) {

        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[new Random().nextInt(Discount.Code.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);

    }

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));

    }

    private double calculatePrice(String product) {

        delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);


    }

    public static void delay() {
        Random random = new Random();
        int delay = 500 + random.nextInt(2000);
        try {
            Thread.sleep(delay);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
