package conditionalandbooleanoperators;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class SkipWhile {
    public static void main(String[] args) {
        
        // Observable.skipWhile(Func1<? extends T,Boolean> func1)
        System.out.println("Observable.skipWhile(Func1<? extends T,Boolean> func1)");
        
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .skipWhile(new Func1<Integer,Boolean>(){
            @Override
            public Boolean call(Integer t) {
                return t < 5;
            }
        }).subscribe(new Subscriber<Integer>(){
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
