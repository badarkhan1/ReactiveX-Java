package errorhandlingoperators;

import rx.Observable;
import rx.Subscriber;

public class Retry {
    public static void main(String[] args) {

        // Observable.retry()
        System.out.println("Observable.retry()");        
        Observable.just(1, 2, 3, 4, 5)
                .retry()
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
