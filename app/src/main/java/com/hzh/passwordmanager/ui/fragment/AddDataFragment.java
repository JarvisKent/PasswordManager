package com.hzh.passwordmanager.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hzh.passwordmanager.R;
import com.hzh.passwordmanager.bean.DataBean;
import com.hzh.passwordmanager.db.dao.DataDao;
import com.hzh.passwordmanager.ui.base.BaseFragment;
/**
 * Created by JarvisHuang on 2016/3/31.
 */
public class AddDataFragment extends BaseFragment implements View.OnClickListener{

    private DataDao dataDao;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_add,container,false);
        initComponent(v);
        return v;
    }
    EditText name,account,password,kind,desc;
    Button add,cancel;
    private void initComponent(View v) {
        name = (EditText) v.findViewById(R.id.et_name);
        account = (EditText) v.findViewById(R.id.et_account);
        password = (EditText) v.findViewById(R.id.et_password);
        kind = (EditText) v.findViewById(R.id.et_kind);
        desc = (EditText) v.findViewById(R.id.et_desc);
        add = (Button) v.findViewById(R.id.btn_add);
        add.setOnClickListener(this);
        cancel = (Button) v.findViewById(R.id.btn_cancel);
        cancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:

                //只要保证账号密码不为空即可
                if (isNotNull(password.getText().toString().trim()) && isNotNull(account.getText().toString().trim()) && isNotNull(kind.getText().toString().trim())){
                    dataDao = new DataDao(getActivity());
                    //弹窗提示确认数据是否保存。
                    DataBean bean = new DataBean();
                    bean.setAccount(account.getText().toString().trim());
                    bean.setKind(Integer.valueOf(kind.getText().toString().trim()));
                    bean.setDesc(desc.getText().toString().trim());
                    bean.setName(name.getText().toString().trim());
                    bean.setPassword(password.getText().toString().trim());
                    dataDao.add(bean);
                    showMessage(bean);
                }else{
                    Toast.makeText(getActivity(),"账号和密码不能为空!",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_cancel:

                //取消则返回主页面
                turnMain();
                break;
            default:
                break;
        }
    }
    FragmentManager mFM;
    private void showMessage(DataBean bean) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("确认保存");
        builder.setMessage("类型："+bean.getName()+"\n 账号："+bean.getAccount()+"\n 描述："+bean.getDesc());
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                turnMain();
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });
        builder.create().show();
    }

    boolean isNotNull(String str){
        return !TextUtils.isEmpty(str);
    }

    void turnMain(){
        Fragment f = new MainListFragment();
        if (null == mFM)
            mFM = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.fl_content, f);
        ft.commit();
    }

}
