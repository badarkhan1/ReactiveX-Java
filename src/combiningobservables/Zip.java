package combiningobservables;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;

public class Zip {
    public static void main(String[] args) {

        // Observable.zip(Observable<? extends T1> ob1 , Observable<? extends T2> ob2,Func2<? extends T1, ? extends T2, ? extends R> func2)
        System.out.println("Observable.zip(Observable<? extends T1> ob1 , Observable<? extends T2> ob2,Func2<? extends T1, ? extends T2, ? extends R> func2)");
        Observable.zip(Observable.just(1, 2), Observable.just("A", "B", "C"), 
                new Func2<Integer,String,String>(){
            @Override
            public String call(Integer t1, String t2) {
                return t2 + t1;
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
