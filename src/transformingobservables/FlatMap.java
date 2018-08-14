package transformingobservables;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;


public class FlatMap {
    public static void main(String[] args){
        
        // Observable.flatMap(Func1<? super T,? extends Observable<? extends R>> func)
        System.out.println("Observable.flatMap(Func1<? super T,? extends Observable<? extends R>> func)");
        Observable.just(1, 2, 3, 4, 5)
                .flatMap(new Func1<Integer,Observable<Integer>>(){
            @Override
            public Observable<Integer> call(Integer t) {
                return Observable.<Integer>just(t*2);
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
