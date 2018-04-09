package com.guoan.tinkertestdemo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tencent.tinker.lib.tinker.TinkerInstaller;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.tv);
        tv.setText("22222");
        Button fix = findViewById(R.id.fix);
        fix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(), Environment.getExternalStorageDirectory().getAbsolutePath()
                        + "/patch_signed_7zip.apk");
                File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()
                        + "/patch_signed_7zip.apk");
                boolean exists = file.exists();
                System.out.println(exists);
            }
        });
    }
}
