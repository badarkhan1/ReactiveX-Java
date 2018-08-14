package filteringobservables;

import rx.Observable;
import rx.Subscriber;

public class TakeLast {
    public static void main(String[] args) {
        
        // Observable.takeLast(int count)
        System.out.println("Observable.takeLast(int count)");
        Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                .takeLast(3)
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
