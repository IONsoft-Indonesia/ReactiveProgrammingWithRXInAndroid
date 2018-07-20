package id.co.ionsoft.ionsoftrx;

import android.os.Bundle;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class MainActivity extends BaseActivity implements Observer<Object> {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ObserverHolder.observable.subscribe(this);
        ObserverHolder.observable.subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {
                Timber.d("onSubscribe observer baru");
            }

            @Override
            public void onNext(Object object) {
                if (object instanceof Endah) {
                    // casting = mengubah object menjadi lebih spesifik
                    ((Endah) object).ngomong();
                } else if (object instanceof Dog) {
                    ((Dog) object).ngomong();
                }
                Timber.d("onNext observer baru %s", object);
            }

            @Override
            public void onError(Throwable e) {
                Timber.d("onError observer baru");
            }

            @Override
            public void onComplete() {
                Timber.d("onComplete observer baru");
            }
        });
    }

    @Override
    public void onSubscribe(Disposable d) {
        textView.append("\nonSubscribe");
        Timber.d("\nonSubscribe");
    }

    @Override
    public void onNext(Object s) {
        textView.append(String.format("\n%s", s));
        Timber.d("\n%s", s);
    }

    @Override
    public void onError(Throwable e) {
        textView.append(String.format("\nonError %s", e.getMessage()));
        Timber.e(e);
    }

    @Override
    public void onComplete() {
        textView.append("\nonComplete");
        Timber.d("\nonComplete");
    }
}
