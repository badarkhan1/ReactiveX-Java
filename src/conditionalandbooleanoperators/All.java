package conditionalandbooleanoperators;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

public class All {
    public static void main(String[] args) {
        
        // Observable.all(Func1<Integer,Boolean> func1)
        System.out.println("Observable.all(Func1<Integer,Boolean> func1)");
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .all(new Func1<Integer,Boolean>(){
            @Override
            public Boolean call(Integer t) {
                return t % 1 == 0;
            }
        }).subscribe(new Subscriber<Boolean>(){
            @Override
            public void onCompleted() {
                System.out.println("All items have been emitted.");
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Something went wrong...");
            }

            @Override
            public void onNext(Boolean t) {
                System.out.print(t + " ");
            }
        });
    }
}
