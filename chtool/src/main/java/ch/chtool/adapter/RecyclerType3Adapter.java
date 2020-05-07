package ch.chtool.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by CH
 * on 2020/5/7 10:06
 */
public abstract class RecyclerType3Adapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private static final int ITEM_Top = 1;
    private static final int ITEM_CONTENT = 2;
    private static final int ITEM_Bottom = 3;
    private Context mContext;
    private int mLayoutId1;
    private int mLayoutId2;
    private int mLayoutId3;
    private List<RecyclerType3Model> mDatas;

    public RecyclerType3Adapter(Context context, int layoutId1, int layoutId2, int layoutId3, List<RecyclerType3Model> datas) {
        this.mContext = context;
        this.mLayoutId1 = layoutId1;
        this.mLayoutId2 = layoutId2;
        this.mLayoutId3 = layoutId3;
        this.mDatas = datas;
    }

    public int getItemViewType(int position) {
        return ((RecyclerType3Model)this.mDatas.get(position)).getViewType();
    }

    public int getItemCount() {
        return this.mDatas == null ? 0 : this.mDatas.size();
    }

    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = null;
        if (1 == viewType) {
            itemView = LayoutInflater.from(this.mContext).inflate(this.mLayoutId1, parent, false);
        }

        if (2 == viewType) {
            itemView = LayoutInflater.from(this.mContext).inflate(this.mLayoutId2, parent, false);
        }

        if (3 == viewType) {
            itemView = LayoutInflater.from(this.mContext).inflate(this.mLayoutId3, parent, false);
        }

        return RecyclerViewHolder.getViewHolder(itemView);
    }

    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        if (this.mDatas != null && this.mDatas.size() > 0) {
            if (1 == this.mDatas.get(position).getViewType()) {
                this.convertType1(holder, this.mDatas.get(position), position);
            }

            if (2 == this.mDatas.get(position).getViewType()) {
                this.convertType2(holder, this.mDatas.get(position), position);
            }

            if (3 == this.mDatas.get(position).getViewType()) {
                this.convertType3(holder, this.mDatas.get(position), position);
            }
        }

    }

    public abstract void convertType1(RecyclerViewHolder var1, RecyclerType3Model var2, int var3);

    public abstract void convertType2(RecyclerViewHolder var1, RecyclerType3Model var2, int var3);

    public abstract void convertType3(RecyclerViewHolder var1, RecyclerType3Model var2, int var3);
}
