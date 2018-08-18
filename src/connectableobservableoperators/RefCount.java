package connectableobservableoperators;

import rx.Observable;
import rx.Subscriber;

public class RefCount {
    public static void main(String[] args) {
        
        // Observable.refCount()
        System.out.println("Observable.refCount()");

        Observable.just(1, 2, 3, 4, 5)
                .publish()
                .refCount()
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
