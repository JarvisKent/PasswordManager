package com.hzh.passwordmanager.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.hzh.passwordmanager.R;

import java.util.List;

/**
 * Created by JarvisHuang on 2016/3/10.
 *
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    public List<String> datas = null;
    public Context context;
    public RecycleViewAdapter(List<String > list,Context context) {
        this.datas = list;
        this.context = context;
    }

    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
//        viewHolder.mTextView.setText(datas.get(position));
        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);

        viewHolder.setTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewHolder.swipeLayout.close();
                Toast.makeText(context,"复制"+datas.get(position)+position,Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              areYouSure();
            }

            private void areYouSure() {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("删除");
                builder.setMessage("确定删除"+datas.get(position)+"?");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        datas.remove(position);
                        notifyItemRemoved(position);
                        viewHolder.swipeLayout.close();
                        notifyItemRangeChanged(position, datas.size());
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.create().show();
            }
        });

    }



    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public TextView m2;
        public com.daimajia.swipe.SwipeLayout swipeLayout;
        public Button setTxt;
        public Button delete;
        public ViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.tv_name);
            m2 = (TextView) view.findViewById(R.id.tv_account);
            swipeLayout = (SwipeLayout) view.findViewById(R.id.swipelayout);

            setTxt = (Button) view.findViewById(R.id.copyTxt);
            delete = (Button) view.findViewById(R.id.delete);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,"点击",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}