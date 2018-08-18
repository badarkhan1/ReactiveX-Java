package observableutilityoperators;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class ObserveOn {
    public static void main(String[] args) {
        
        // Observable.observeOn(Scheduler scheduler)
        System.out.println("Observable.observeOn(Scheduler scheduler)");
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .map(new Func1<Integer,String>(){
            @Override
            public String call(Integer t) {
                return "Performing operation on  " + t + " on " + Thread.currentThread().getName() + "\n";
            }
        })
          .observeOn(Schedulers.computation())
                .map(new Func1<String,String>(){
            @Override
            public String call(String t) {
                return "Performing this operation on " + Thread.currentThread().getName();
            }
        })
            .observeOn(Schedulers.immediate())
          .subscribe(new Subscriber<String>(){
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
                System.out.println();
            }
        });
    }
}
