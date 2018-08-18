package conditionalandbooleanoperators;

import rx.Observable;
import rx.Subscriber;

public class SkipUntil {
    public static void main(String[] args) {
        
        // Observable.skipUntil(Observable<T> ob1)
        System.out.println("Observable.skipUntil(Observable<T> ob1)");

        Observable.just(1, 2, 3)
                .skipUntil(Observable.just("A", "B", "C"))
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
