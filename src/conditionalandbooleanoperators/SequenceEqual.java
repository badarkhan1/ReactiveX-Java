package conditionalandbooleanoperators;

import rx.Observable;
import rx.Subscriber;

public class SequenceEqual {
    public static void main(String[] args) {
        
        // Observable.sequenceEqual(Observable<T> ob1 , Observable<T> ob2)
        System.out.println("Observable.sequenceEqual(Observable<T> ob1 , Observable<T> ob2");

        Observable.sequenceEqual(Observable.just(1, 2, 3), Observable.just(1, 2, 3))
                .subscribe(new Subscriber<Boolean>(){
            @Override
            public void onCompleted() {
                System.out.println("All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(Boolean t) {
                System.out.print(t + " ");
            }
        });
    }
}
