package filteringobservables;

import rx.Observable;
import rx.Subscriber;

public class SkipLast {
    public static void main(String[] args) {
        
        // Observable.skipLast(int count)
        System.out.println("Observable.skipLast(int count)");
        Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                .skipLast(5)
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
