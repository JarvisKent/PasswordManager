package com.hzh.passwordmanager.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hzh.passwordmanager.R;
import com.hzh.passwordmanager.bean.DataBean;
import com.hzh.passwordmanager.db.dao.DataDao;
import com.hzh.passwordmanager.ui.base.BaseFragment;
import com.hzh.passwordmanager.utils.SwitchPage;

/**
 * Created by JarvisHuang on 2016/4/5.
 */
public class MotifyDataFragment extends BaseFragment implements View.OnClickListener {
    DataDao dataDao;
    EditText name;
    EditText id;
    EditText pwd;
    EditText kind;
    EditText desc;
    DataBean datas;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_motify_data,container,false);

        name = (EditText) view.findViewById(R.id.modify_name);
        id = (EditText) view.findViewById(R.id.modify_account);
        pwd = (EditText) view.findViewById(R.id.modify_password);
        kind = (EditText) view.findViewById(R.id.modify_kind);
        desc = (EditText) view.findViewById(R.id.modify_desc);
        Button modify = (Button) view.findViewById(R.id.btn_modify);
        Button cancel = (Button) view.findViewById(R.id.modify_cancel);
        cancel.setOnClickListener(this);
        modify.setOnClickListener(this);
        Bundle data = getArguments();
        datas = data.getParcelable("modifyData");
        if(datas!=null && datas.toString() !="") {
            name.setText(datas.getName());
            id.setText(datas.getAccount());
            pwd.setText(datas.getPassword());
            kind.setText(datas.getKind()+"");
            desc.setText(datas.getDesc());
        }
        return view;
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.btn_modify:
          dataDao = new DataDao(getActivity());
            DataBean bean = new DataBean();
            bean.setName(name.getText().toString().trim());
            bean.setId(datas.getId());
            bean.setAccount(id.getText().toString().trim());
            bean.setDesc(desc.getText().toString().trim());
            bean.setKind(Integer.parseInt(kind.getText().toString().trim()));
            bean.setPassword(pwd.getText().toString().trim());
            dataDao.update(bean);
            Toast.makeText(getActivity(),"修改成功!",Toast.LENGTH_LONG).show();
            SwitchPage.toMain(getActivity(),R.id.fl_content);
            break;
        case R.id.modify_cancel:
            SwitchPage.toMain(getActivity(),R.id.fl_content);
            break;
    }

    }
}
