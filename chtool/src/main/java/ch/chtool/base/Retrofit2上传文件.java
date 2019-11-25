package ch.chtool.base;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by CH
 * on 2019/11/25 16:29
 */
public class Retrofit2上传文件 {
    private List<File> mFileList = new ArrayList<>();

    private void uploadPic() {
        List<MultipartBody.Part> files2 = new ArrayList<>();
        //TODO 上传多张图片
        for (int i = 0; i < mFileList.size(); i++) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), mFileList.get(i));
            MultipartBody.Part form = MultipartBody.Part.createFormData("files", mFileList.get(i).getName(), requestBody);
            files2.add(form);
        }
//        Call<T> call = HttpUtils.getInstance().getApiService(ApiService.class).upload(files2);
////        call.enqueue(callback);
    }
}
