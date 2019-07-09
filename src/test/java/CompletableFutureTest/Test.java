/**
 * Description:
 * User: daipeng
 * Date: 2019-06-25 17:28
 * Project:CodeSnippet
 */
package CompletableFutureTest;

import jdk.nashorn.internal.runtime.QuotedStringTokenizer;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    private List<Shop> shops = new ArrayList(){{
        add(new Shop("a"));
        add(new Shop("b"));
        add(new Shop("c"));
        add(new Shop("d"));


    }};
    private final Executor executor = Executors.newFixedThreadPool(Math.min(shops.size(), 100), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    });




    public static void main(String[] args) {
        Test ts = new Test();
        Long cur = System.currentTimeMillis();


        CompletableFuture[] futures = ts.findPricesStream("my").map(f -> f.thenAccept(s -> System.err.println(s + "done in " + ((System.currentTimeMillis() - cur))))).toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();



        Long now = System.currentTimeMillis();
        System.err.println(now - cur);

    }

    public List<String> findPrices(String product) {
//        List<CompletableFuture<String>> priceFutures = shops.stream().map(shop -> CompletableFuture.supplyAsync(()->String.format("%s price is %.2f", shop.getName(), shop.getPrice(product)),executor)).collect(Collectors.toList());

//        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());

//        return shops.stream().map(shop -> shop.getPrice(product)).map(Quote::parse).map(Discount::applyDiscount).collect(Collectors.toList());

        List<CompletableFuture<String>> priceFutures = shops.stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)))
                .collect(Collectors.toList());
        return priceFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());

    }

    public Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), executor)));
    }
}
