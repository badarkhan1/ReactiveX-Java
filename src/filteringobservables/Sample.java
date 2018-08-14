package filteringobservables;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscriber;

public class Sample {
    public static void main(String[] args) {
        
        // Observable.sample(Long period,TimeUnit timeUnit)
        System.out.println("Observable.sample(Long period,TimeUnit timeUnit)");
        Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                .sample(1,TimeUnit.NANOSECONDS)
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
