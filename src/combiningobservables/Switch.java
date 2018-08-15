package combiningobservables;

import rx.Observable;
import rx.Subscriber;

public class Switch {
    public static void main(String[] args) {
        
        // Observable.switch(Observable<? extends T> ob1 , Observable<? extends T> ob2)
        System.out.println("Observable.switch(Observable<? extends T> ob1 , Observable<? extends T> ob2)");
        
            Observable
                .just(Observable.just(1, 2, 3,4,5,6,7,8,9,10),Observable.just(11,12,13,14,15,16,17,18,19,20),Observable.just(7, 8, 9))
                .subscribe(new Subscriber<Observable<Integer>>(){
            @Override
            public void onCompleted() {
                System.out.println("All observables have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(Observable<Integer> t) {
                t.subscribe(new Subscriber<Integer>(){
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
                
                System.out.println();
            }
        });
    }
}
