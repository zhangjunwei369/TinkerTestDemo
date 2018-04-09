package com.guoan.tinkertestdemo;

import android.util.Log;

import com.tencent.tinker.lib.service.DefaultTinkerResultService;
import com.tencent.tinker.lib.service.PatchResult;

import java.io.File;

/**
 * Created by Mr.che on 2017/3/1.
 */

public class TinkerResultService extends DefaultTinkerResultService {
    private static final String TAG = "TinkerResultService";
    @Override
    public void onPatchResult(PatchResult result) {
//        super.onPatchResult(result);   把这行注释掉，屏蔽掉父类中的方法
        if (result == null) {
            Log.e(TAG, "TinkerResultService received null result!!!!");
            return;
        }
        Log.e(TAG, "TinkerResultService receive result: %s" + result.toString());
        //first, we want to kill the recover process
//        TinkerServiceInternals.killTinkerPatchServiceProcess(getApplicationContext());

        if(result.isSuccess){    //修复成功
            Log.e(TAG,"修复成功");
            deleteRawPatchFile(new File(result.rawPatchFilePath));  //删除补丁包
            Log.e(TAG,"删除补丁");
        }

    }
}
