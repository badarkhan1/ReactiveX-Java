package observableutilityoperators;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class Delay {
    public static void main(String[] args) {
        
        // Observable.delay(int delay, TimeUnit timeUnit)
        System.out.println("Observable.delay(int delay, TimeUnit timeUnit)");

        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .delay(3000, TimeUnit.SECONDS)
                .subscribe(new Subscriber<Integer>(){
            @Override
            public void onCompleted() {
                System.out.println("All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(Integer t) {
                System.out.print(t + " ");
            }
        });

    }
}
