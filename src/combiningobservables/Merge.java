package combiningobservables;

import rx.Observable;
import rx.Subscriber;

public class Merge {
    public static void main(String[] args) {
        
        // Observable.mergeWith(Observable<? extends T> ob)
        System.out.println("Observable.mergeWith(Observable<? extends T> ob)");        
        Observable.just(1, 2, 3, 4, 5)
                .mergeWith(Observable.just(6, 7, 8, 9, 10))
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
