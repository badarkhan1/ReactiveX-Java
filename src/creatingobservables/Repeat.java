package creatingobservables;

import rx.Observable;
import rx.Subscriber;


public class Repeat {
    public static void main(String[] args){
        
        // Observable.repeat()
        System.out.println("Observable.repeat()");
        Observable<Integer> obsrvble = Observable.just(1, 2, 3, 4, 5).repeat();
        obsrvble.subscribe(new Subscriber<Integer>(){
            @Override
            public void onCompleted() {
                System.out.println(" All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(Integer t) {
                System.out.print(t);
            }
        });
    }
}
