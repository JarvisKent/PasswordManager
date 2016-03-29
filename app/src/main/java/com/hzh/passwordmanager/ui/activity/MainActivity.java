package com.hzh.passwordmanager.ui.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.hzh.passwordmanager.R;
import com.hzh.passwordmanager.ui.base.BaseActivity;
import com.hzh.passwordmanager.ui.fragment.MainListFragment;
import com.hzh.passwordmanager.ui.fragment.ModifyShowPassword;
import com.hzh.passwordmanager.ui.fragment.SettingFragment;
import com.hzh.passwordmanager.ui.fragment.WriteAndRead;
import com.hzh.passwordmanager.utils.TranslucentStatus;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import butterknife.Bind;

public class MainActivity extends BaseActivity {

    FragmentManager mFM;

    FrameLayout fl;

    @Bind(R.id.tl_custom)
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //自定义Toolbar
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);

        //沉浸式状态栏
        TranslucentStatus.initState(this,R.id.ll_bar);

        changeMain();
    }

    @Override
    protected void onStart() {
        super.onStart();
        SlideDraw(toolbar);
    }

    private void changeMain(){
        Fragment f = new MainListFragment();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.fl_content, f);
        ft.commit();
    }
    private void changeSetting(){
        Fragment f = new SettingFragment();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.fl_content, f);
        ft.commit();
    }
    private void changeWriteAndRead(){
        Fragment f = new WriteAndRead();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.fl_content, f);
        ft.commit();
    }
    private void changeModifyPassword(){
        Fragment f = new ModifyShowPassword();
        if (null == mFM)
            mFM = getSupportFragmentManager();
        FragmentTransaction ft = mFM.beginTransaction();
        ft.replace(R.id.fl_content, f);
        ft.commit();
    }

    private void SlideDraw(Toolbar toolbar) {
        //自定义侧边栏
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(R.drawable.material_drawer_badge);
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withName(R.string.writeAndread);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.mipmap.cb0304yp02)
                .addProfiles(
                        new ProfileDrawerItem().withName("hzh").withEmail("000000000@qq.com").withIcon(getResources().getDrawable(R.mipmap.ic_launcher))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        Toast.makeText(MainActivity.this,profile.getName().getText().toString(),Toast.LENGTH_LONG).show();
                        return false;
                    }
                })
                .build();

        new DrawerBuilder().withActivity(this).withToolbar(toolbar).
                withAccountHeader(headerResult)
                .withActionBarDrawerToggle(true)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new SecondaryDrawerItem().withName(R.string.modifyPwd),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_settings)

                ) .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {

            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                changeFragment(position);

                return false;
            }
        }).build();
    }

    private void changeFragment(int position) {
        switch(position){
            case 1://首页
                changeMain();
                break;
            case 3://导入导出
                changeWriteAndRead();
                break;
            case 4://修改查看密码
                changeModifyPassword();
                break;
            case 5://设置
                changeSetting();
                break;
            default:
                Toast.makeText(MainActivity.this,"选了什么"+position,Toast.LENGTH_LONG).show();
                break;
        }
    }

    //创建Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //menu项的点击事件
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(MainActivity.this, "关于作者", Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }

}
