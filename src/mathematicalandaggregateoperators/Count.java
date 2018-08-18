package mathematicalandaggregateoperators;

import rx.Observable;
import rx.Subscriber;

public class Count {
    public static void main(String[] args) {
        
        // Observable.count()
        System.out.println("Observable.count()");

        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .count()
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
