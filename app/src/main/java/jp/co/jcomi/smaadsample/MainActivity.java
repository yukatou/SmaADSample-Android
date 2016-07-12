package jp.co.jcomi.smaadsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import jp.gmotech.smaad.video.ad.SmaAdVideo;
import jp.gmotech.smaad.video.ad.SmaAdVideoListener;

public class MainActivity extends AppCompatActivity {

    // SmaAD 広告枠 ID(管理画面から取得可能)
    private static final String TEST_VIDEO_ZONE_ID = "490910056";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String userId = "1234";
        SmaAdVideo.setDebug(true);

        SmaAdVideo.initialize(this, TEST_VIDEO_ZONE_ID, userId, false, new SmaAdVideoListener() {
            @Override
            public void onSmaAdVideoInitEnd() {
                Log.d("TEST", "onSmaAdVideoInitEnd");
            }

            @Override
            public void onSmaAdVideoInitError(int i) {
                Log.d("TEST", "onSmaAdVideoInitError");
                Log.d("TEST", String.valueOf(i));
            }

            @Override
            public void onSmaAdVideoReady() {
                Log.d("TEST", "onSmaAdVideoReady");
            }

            @Override
            public void onSmaAdVideoError(int i) {
                Log.d("TEST", "onSmaAdVideoError");
                Log.d("TEST", String.valueOf(i));
            }

            @Override
            public void onSmaAdVideoStart() {

            }

            @Override
            public void onSmaAdVideoComplete(String s) {

            }

            @Override
            public void onSmaAdVideoStop() {

            }

            @Override
            public void onSmaAdEndcardClosed() {

            }
        });


        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 動画再生可能かをチェックし、
                if (SmaAdVideo.canPlayVideo(TEST_VIDEO_ZONE_ID)) {
                    // 可能ならば動画再生
                    SmaAdVideo.playVideo(MainActivity.this, TEST_VIDEO_ZONE_ID);
                } else {
                    Log.d("TEST", "cannot play video.");
                }
            }
        });

    }
}
