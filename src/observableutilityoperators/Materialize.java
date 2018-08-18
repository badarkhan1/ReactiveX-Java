package observableutilityoperators;

import rx.Notification;
import rx.Observable;
import rx.Subscriber;

public class Materialize {
    public static void main(String[] args) {
        
        // Observable.materialize()
        System.out.println("Observable.materialize()");

        Observable.just(1, 2, 3, 4, 5)
                .materialize()
                .subscribe(new Subscriber<Notification<Integer>>(){
            @Override
            public void onCompleted() {
                System.out.println("All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(Notification<Integer> t) {
                System.out.print(t + " ");
            }
        });
    }
}
