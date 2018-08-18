package observableutilityoperators;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class SubscribeOn {
    public static void main(String[] args) {
        
        // Observable.subscribeOn(Scheduler scheduler)
        System.out.println("Observable.subscribeOn(Scheduler scheduler)");

        Observable.just(1, 2, 3, 4, 5)
                .subscribeOn(Schedulers.computation())
                .map(new Func1<Integer,String>(){
            @Override
            public String call(Integer t) {
                return t + " " + Thread.currentThread().getName();
            }
        }).subscribe(new Subscriber<String>(){
            @Override
            public void onCompleted() {
                System.out.println("All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(String t) {
                System.out.println(t);
            }
        });
    }
}
