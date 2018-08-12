
package creatingobservables;

import rx.Observable;
import rx.Subscriber;


public class Range {
    public static void main(String[] args){
        
        // Observable.range(int start, int count)
        System.out.println("Observable.just(int start, int count)");
        Observable<Integer> obsrvble = Observable.range(2, 10);
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
