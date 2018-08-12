package creatingobservables;

import rx.Observable;
import rx.Subscriber;


public class Just {
    public static void main(String[] args){
        
        // Observable.just(T t)
        System.out.println("Observable.just(T t)");
        Observable<Integer> obsrvble = Observable.just(1, 2,3,4,5,6,7,8,9,10);
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
