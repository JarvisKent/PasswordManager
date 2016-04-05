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

import com.daimajia.swipe.SwipeLayout;
import com.hzh.passwordmanager.R;
import com.hzh.passwordmanager.bean.DataBean;
import com.hzh.passwordmanager.db.dao.DataDao;

import java.util.List;

/**
 * Created by JarvisHuang on 2016/3/10.
 */
public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ViewHolder> {
    public List<DataBean> datas = null;
    public Context context;
    public MainListAdapter(List<DataBean> list, Context context) {
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
        viewHolder.tvName.setText("类型："+datas.get(position).getName());
        viewHolder.tvAccount.setText("账号："+datas.get(position).getAccount());
        viewHolder.tvDesc.setText("描述："+datas.get(position).getDesc());
        viewHolder.swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);

        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                areYouSure(position);
            }

            private void areYouSure(final int position) {

                final DataDao dao = new DataDao(context);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("删除");
                builder.setMessage("确定删除"+datas.get(position)+"?");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        notifyItemRemoved(position);
                        dao.deleteByAccount(datas.get(position).getAccount());
                        datas.remove(position);
                        viewHolder.swipeLayout.close();
                        notifyDataSetChanged();
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

    /**
     *获取数据的数量
     */
    @Override
    public int getItemCount() {

        return datas.size();
    }

    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName,tvDesc,tvAccount;
        public com.daimajia.swipe.SwipeLayout swipeLayout;
        public Button delete;
        public ViewHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tv_name);
            tvAccount = (TextView) view.findViewById(R.id.tv_account);
            tvDesc = (TextView) view.findViewById(R.id.tv_desc);
            swipeLayout = (SwipeLayout) view.findViewById(R.id.swipelayout);
            delete = (Button) view.findViewById(R.id.delete);
        }
    }

}