package observableutilityoperators;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

public class Do {
    public static void main(String[] args) {
        
        // Observable.doOnNext(Action1<? extends T> action1)
        System.out.println("Observable.doOnNext(Action1<? extends T> action1)");
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .doOnNext(new Action1<Integer>(){
            @Override
            public void call(Integer t) {
                System.out.println("Emitting integer " + t);
            }
        }).doOnError(new Action1<Throwable>(){
            @Override
            public void call(Throwable t) {
                System.out.println("Something went wrong...");
            }
        }).doOnCompleted(new Action0() {
            @Override
            public void call() {
                System.out.println("All items have been emitted.");
            }
        }).subscribe();
    }
}
