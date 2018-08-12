
package creatingobservables;

import rx.Observable;
import rx.Subscriber;


public class Error {
    public static void main(String[] args){

        // Observable.error()
        System.out.println("Observable.error()");
        Observable<Integer> obsrvrble = Observable.error(new Exception());
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
