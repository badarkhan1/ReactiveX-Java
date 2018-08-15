package combiningobservables;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

public class CombineLatest {
    public static void main(String[] args) {
        
        Observable.combineLatest(Observable.<Integer>just(1,2,3,4,5), Observable.<String>just("A","B","C","D"),
                new Func2<Integer,String,String>(){
            @Override
            public String call(Integer t1, String t2) {
                return t1 + t2;
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
                System.out.print(t + " ");
            }
        });
    }
}
