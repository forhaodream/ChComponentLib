package ch.chtool.adapter;

/**
 * Created by CH
 * on 2020/5/7 10:06
 */
public class RecyclerType3Model<T> {
    private int viewType;
    private T Bean;

    public RecyclerType3Model() {
    }

    public RecyclerType3Model(int viewType, T Bean) {
        this.viewType = viewType;
        this.Bean = Bean;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public T getBean() {
        return this.Bean;
    }

    public void setBean(T bean) {
        this.Bean = bean;
    }
}