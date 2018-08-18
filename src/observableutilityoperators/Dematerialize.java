package observableutilityoperators;

import rx.Notification;
import rx.Observable;
import rx.Subscriber;

public class Dematerialize {
    public static void main(String[] args) {
        
        // Observable.dematerialize()
        System.out.println("Observable.dematerialize())");
        Observable.just(1, 2, 3, 4, 5)
                .materialize()
                .dematerialize()
                .subscribe(new Subscriber<Object>(){
            @Override
            public void onCompleted() {
                System.out.println("All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(Object t) {
                System.out.print(t + " ");
            }
        });
    }
}
