package creatingobservables;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func0;
import rx.observables.SyncOnSubscribe;


public class Defer {
    public static void main(String[] args){
        
        // Observable.defer(Func0<Observable<T>> func0)
        System.out.println("Observable.defer(Func0<Observable<T>> func0)");
        Observable<Integer> obsrvrble = Observable.defer(new Func0<Observable<Integer>>(){
            @Override
            public Observable<Integer> call() {
                return Observable.create(new SyncOnSubscribe<Integer,Integer>(){
                    private int count = 0;
                    private int value = 0;

                    @Override
                    protected Integer generateState() {
                        count++;
                        return ++value;
                    }

                    @Override
                    protected Integer next(Integer s, Observer<? super Integer> obsrvr) {
                        try {
                            if (count <= 10) {
                                count++;
                                obsrvr.onNext(s);
                                return ++value;
                            } else {
                                obsrvr.onCompleted();
                            }

                        } catch (Exception e) {
                            obsrvr.onError(e);
                        }
                        return null;
                    }
                });
            }
        });
        
        obsrvrble.subscribe(new Subscriber<Integer>(){
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
        
        obsrvrble.subscribe(new Subscriber<Integer>() {
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
