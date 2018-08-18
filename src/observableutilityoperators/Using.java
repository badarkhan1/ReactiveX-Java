package observableutilityoperators;

import javax.annotation.Resource;
import rx.Observable;
import rx.functions.Func0;

public class Using {
    public static void main(String[] args) {
        
        // Observable.using(Func0<Resource> resourceFactory, Func1<Rsource,Observable<? extends T> obsrvbleFactory,Action1<? extends Rsource> resourceDisposal)
        System.out.println("Observable.using(Func0<Resource> resourceFactory, Func1<Rsource,Observable<? extends T> obsrvbleFactory,Action1<? extends Rsource> resourceDisposal");
        // The using operator is ambiguous
//        Observable.using(resourceFactory, observableFactory, disposeAction);
    }
}
