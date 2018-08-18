package observableutilityoperators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;

public class TimeOut {
    public static void main(String[] args) {
        
        // Observable.timeOut(int delay, TimeUnit timeUnit)
        System.out.println("Observable.timeOut(int delay, TimeUnit timeUnit)");

        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .timeout(1, TimeUnit.SECONDS)
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
