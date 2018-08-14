package filteringobservables;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class Debounce {
    public static void main(String[] args) {
        
        // Observable.debounce(Long delay,TimeUnit timeUnit)
        System.out.println("Observable.debounce(Long delay,TimeUnit timeUnit)");
        Observable.from(new Integer[]{0,1,2,3,4,5,6,7,8,9,10})
                .debounce(2,TimeUnit.SECONDS)
                .observeOn(Schedulers.immediate())
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
