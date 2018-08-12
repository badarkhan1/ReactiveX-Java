package creatingobservables;

import rx.Observable;
import rx.Subscriber;


public class Never {
    public static void main(String[] args){

        // Observable.never()
        System.out.println("Observable.never()");        
        Observable<Integer> obsrvrble = Observable.never();
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
