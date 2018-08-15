package combiningobservables;

import rx.Observable;
import rx.Subscriber;

public class StartWith {
    public static void main(String[] args) {
        
        // Observable.concat(Observable<? extends T> ob1 , Observable<? extends T> ob2)
        System.out.println("Observable.mergeWith(Observable<? extends T> ob1 , Observable<? extends T> ob2)");
        Observable.just(1, 2, 3, 4, 5)
                .startWith(Observable.just(-1, -2, -3))
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
