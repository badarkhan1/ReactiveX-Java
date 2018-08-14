package transformingobservables;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;

public class Scan {
    public static void main(String[] args){
        
        // Observable.scan(Func2<? extends T, ? extends T, ? extends T> func2)
        System.out.println("Observable.scan(Func2<? extends T, ? extends T, ? extends T> func2)");
        Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .scan(new Func2<Integer,Integer,Integer>(){
            @Override
            public Integer call(Integer t1, Integer t2) {
                return t1 + t2;
            }
        }).subscribe(new Subscriber<Integer>(){
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
