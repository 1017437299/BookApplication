package bnuz.it.lq.bookapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class SplashActivity extends AppCompatActivity {

    public static final int CODE = 1001;
    public static final int TOTAL_TIME = 3000;
    public static TextView tv_skip;
    private MyHandler handler;
    private static Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();


    }

    private void init() {
        handler = new MyHandler(this);
        Message message = Message.obtain();
        message.what = CODE;
        message.arg1 = TOTAL_TIME;
        handler.sendMessage(message);

        //initView
        context=this;
        tv_skip=findViewById(R.id.Splash_tv_skip);
        tv_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BookListActivity.start(context);
                handler.removeMessages(CODE);
            }
        });

    }



    public static class MyHandler extends Handler {
        public static final int BREAKTIME = 1000;
        public final WeakReference<SplashActivity> mWeakReference;

        public MyHandler(SplashActivity activity) {
            mWeakReference = new WeakReference<>(activity);
        }

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            SplashActivity activity = mWeakReference.get();
            if (msg.what == CODE) {
                int time = msg.arg1;
                tv_skip.setText("跳过"+(msg.arg1/1000)+"秒");
                if(time==0){
                    BookListActivity.start(context);
                    tv_skip.setVisibility(View.INVISIBLE);
                }

                if (activity != null) {
                    Message message = Message.obtain();
                    message.what = CODE;
                    message.arg1 = time - BREAKTIME;
                    if (time > 0) {
                        sendMessageDelayed(message, BREAKTIME);
                    }

                }
            }
        }
    }


}