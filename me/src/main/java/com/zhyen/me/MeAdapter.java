package com.zhyen.me;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.PipedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * author : fengxing
 * date : 2022/5/25 上午10:40
 * description :
 */
public class MeAdapter extends RecyclerView.Adapter<MeAdapter.MeHold> {

    private final List<AdapterData> list;

    public MeAdapter() {
        list = new ArrayList<AdapterData>();
        list.add(new AdapterData("我的圈子"));
        list.add(new AdapterData("我的收藏"));
        list.add(new AdapterData("我的果园"));
        list.add(new AdapterData("我的专属技师"));
        list.add(new AdapterData("服务记录"));
        list.add(new AdapterData("设置"));
        list.add(new AdapterData("客户电话"));
        list.add(new AdapterData("扫一扫"));
        list.add(new AdapterData("邀请好友"));
    }

    @NonNull
    @Override
    public MeHold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.me_main_adapter_layout, parent,false);
        return new MeHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MeHold holder, int position) {
        MeItemView item = (MeItemView) holder.itemView;
        item.setViewData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MeHold extends RecyclerView.ViewHolder {

        public MeHold(@NonNull View itemView) {
            super(itemView);
        }
    }
}
