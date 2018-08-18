package mathematicalandaggregateoperators;

import rx.Observable;
import rx.Subscriber;

public class Concat {
    public static void main(String[] args) {
        
        // Observable.concat(Observable<T> ob1 , Observable<T> ob2)
        System.out.println("Observable.concat(Observable<T> ob1 , Observable<T> ob2)");

        Observable.concat(Observable.just(1, 2, 3), Observable.just(4, 5, 6))
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
