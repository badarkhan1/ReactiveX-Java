package creatingobservables;

import rx.Observable;
import rx.Subscriber;


public class Empty {
    public static void main(String[] args){
        
        // Observable.empty()
        System.out.println("Observable.empty()");
        Observable<Integer> obsrvrble = Observable.empty();
        obsrvrble.subscribe(new Subscriber<Integer>(){
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
