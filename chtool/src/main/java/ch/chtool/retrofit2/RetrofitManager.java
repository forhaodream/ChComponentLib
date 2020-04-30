package ch.chtool.retrofit2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;

/**
 * Created by CH
 * on 2019/11/25 16:42
 */
public class RetrofitManager<T> {
    private Call<T> request;
    private static RetrofitManager mInstance;
    RequestBody requestBody;

    private RetrofitManager() {

    }

    public static RetrofitManager getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }
        return mInstance;
    }


    public static abstract class ResultCallBack<T> {

        public abstract void onError(Request request, Exception e);

        public abstract void onResponse(T response);
    }

    private void fileList(Class apiClz, Class bean, List<File> fileList) {
        List<MultipartBody.Part> files2 = new ArrayList<>();
        //TODO 上传多张图片
        for (int i = 0; i < fileList.size(); i++) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), fileList.get(i));
            MultipartBody.Part form = MultipartBody.Part.createFormData("files", fileList.get(i).getName(), requestBody);
            files2.add(form);
        }
//        Call<bean> call = HttpUtils.getInstance().getApiService(apiClz).upload(files2);
//        call.enqueue(new Callback<bean>() {
//            @Override
//            public void onResponse();
//        });

    }
}
