package observableutilityoperators;

import rx.Observable;
import rx.Subscriber;

public class Subscribe {
    public static void main(String[] args) {

        // Observable.subscribe(Subscriber<? extends T> subscriber)
        System.out.println("Observable.subscribe(Subscriber<? extends T> subscriber)");        
        Observable.just(1, 2, 3, 4, 5)
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
