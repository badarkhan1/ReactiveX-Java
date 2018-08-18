package conditionalandbooleanoperators;

import rx.Observable;
import rx.Subscriber;

public class TakeUntil {
    public static void main(String[] args) {
        
        // Observable.takeUntil(Observable<T> observable)
        System.out.println("Observable.takeUntil(Observable<T> observable)");

        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .takeUntil(Observable.just("A", "B", "C", "D", "E", "F", "G", "H", "I", "J"))
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
