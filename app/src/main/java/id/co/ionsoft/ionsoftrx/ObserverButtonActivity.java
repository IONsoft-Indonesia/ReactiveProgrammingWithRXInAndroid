package id.co.ionsoft.ionsoftrx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author hendrawd on 20/07/18
 */
public class ObserverButtonActivity extends AppCompatActivity {
    @BindView(R.id.button)
    Button button;
    private boolean isRequesting = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_button);
        ButterKnife.bind(this);

        Observable<Object> clickObservable = RxView.clicks(button);
        clickObservable.subscribe(new Observer<Object>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                // kalau misal request ke network buat debouncingnya kira2 spt ini
                if(!isRequesting){
                    isRequesting = true;
                    // network request
                    // waiting
                    // network request selesai
                    isRequesting = false;
                }

                Toast.makeText(ObserverButtonActivity.this, "Button clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
