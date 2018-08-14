package filteringobservables;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class Last {
    public static void main(String[] args) {
        
        // Observable.last()
        System.out.println("Observable.last()");
        Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                .last(new Func1<Integer,Boolean>(){
            @Override
            public Boolean call(Integer t) {
                return t >= 7;
            }
        }).subscribe(new Subscriber<Integer>(){
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
