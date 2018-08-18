package conditionalandbooleanoperators;

import rx.Observable;
import rx.Subscriber;

public class Amb {
    public static void main(String[] args) {
        
        // Observable.amb(Observable<T> ob1, Observable<T> ob2)
        System.out.println("Observable.amb(Observable<T> ob1, Observable<T> ob2)");
        Observable.amb(Observable.just(1, 2, 3), Observable.just(4, 5, 6))
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
