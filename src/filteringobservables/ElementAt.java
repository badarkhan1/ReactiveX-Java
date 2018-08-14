package filteringobservables;

import rx.Observable;
import rx.Subscriber;

public class ElementAt {
    public static void main(String[] args) {

        // Observable.elementAt(int index)
        System.out.println("Observable.elementAt(int index)");        
        Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                .elementAt(4)
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
