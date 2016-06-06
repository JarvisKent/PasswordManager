package com.hzh.passwordmanager.ui.activity;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.hzh.passwordmanager.R;
import com.hzh.passwordmanager.ui.base.BaseActivity;
import com.hzh.passwordmanager.utils.SwitchPage;
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


public class MainActivity extends BaseActivity {

    private static final String TAG = "MainActivity";


    FrameLayout fl;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.tl_custom);
        //自定义Toolbar
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);
        //沉浸式状态栏
        TranslucentStatus.initState(this,R.id.ll_bar);

        changeFragment(SwitchPage.MAIN);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        SlideDraw(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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

        new DrawerBuilder().withActivity(this).withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .withActionBarDrawerToggle(true)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new SecondaryDrawerItem().withName(R.string.modifyPwd),
                        new SecondaryDrawerItem().withName(R.string.kind_manager).withDescription("根据权重进行管理"),
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
                SwitchPage.toMain(this,R.id.fl_content);
                break;
            case 3://导入导出
                SwitchPage.toImportAndExport(this,R.id.fl_content);
                break;
            case 4://修改查看密码
                SwitchPage.toMotifyPassword(this,R.id.fl_content);
                break;
            case 5://设置
                SwitchPage.toSetting(this,R.id.fl_content);
                break;
            default:
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

    //  private long exitTime = 0;
    public boolean onKeyDown(int keyCode, KeyEvent event) {

//        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
//            if((System.currentTimeMillis()-exitTime) > 2000){
//                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
//                exitTime = System.currentTimeMillis();
//            } else {
//                ActivityCollector.finishAll();
//            }
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {

//            if(SwitchPage.CURRENT_PAGE != SwitchPage.MAIN){
//                SwitchPage.toMain(this,R.id.fl_content);
//            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("退出程序");
                builder.setMessage("确认退出应用 ？");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        ActivityManager manager = (ActivityManager)MainActivity.this.getSystemService(ACTIVITY_SERVICE); //获取应用程序管理器
//                        manager.killBackgroundProcesses(getPackageName()); //强制结束当前应用程序

                        int pid = android.os.Process.myPid();	//获取当前应用程序的PID
                        android.os.Process.killProcess(pid);	//杀死当前进程
                        //    http://blog.jobbole.com/66117/  状态丢失
//                        ActivityCollector.finishAll();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.create().show();
//            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
