package creatingobservables;

import rx.Completable.OnSubscribe;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.observables.AsyncOnSubscribe;
import rx.observables.SyncOnSubscribe;

public class Create {
    public static void main(String[] args){        

        // Observable.create(SyncOnSubscribe<S,T> synOnSubscribe))
        System.out.println("Observable.create(SyncOnSubscribe<S,T> synOnSubscribe))");
        Observable.create(new SyncOnSubscribe<Integer,Integer>(){
            private int count = 0;
            private int value = 0;
            @Override
            protected Integer generateState() {
                count++;
                return ++value;
            }

            @Override
            protected Integer next(Integer s, Observer<? super Integer> obsrvr) {
                try{
                    if (count <= 10) {
                        count++;
                        obsrvr.onNext(s);
                        return ++value;
                    } else {
                        obsrvr.onCompleted();
                        count = value = 0;
                    }
                    
                }catch(Exception e){
                    obsrvr.onError(e);
                }
                return null;
            }
        }).subscribe(new Subscriber<Integer>() {
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
        
        // Observable.create(AsyncOnSubscribe<S,T> asyncOnSubscribe)
        System.out.println("Observable.create(AsyncOnSubscribe<S,T> asyncOnSubscribe))");
        Observable.create(new AsyncOnSubscribe<Integer,Integer>(){
            private int count = 0;
            private int value = 0;

            @Override
            protected Integer generateState() {
                count++;
                return ++value;
            }

            @Override
            protected Integer next(Integer s, long l, Observer<Observable<? extends Integer>> obsrvr) {
                System.out.print("");
                try {
                    if (count <= 10) {
                        count++;
                        obsrvr.onNext(Observable.<Integer>just(s));
                        return ++value;
                    } else {
                        obsrvr.onCompleted();
                        count = value = 0;
                    }

                } catch (Exception e) {
                    obsrvr.onError(e);
                }
                return null;
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
