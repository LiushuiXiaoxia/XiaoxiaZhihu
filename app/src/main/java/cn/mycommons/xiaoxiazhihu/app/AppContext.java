package cn.mycommons.xiaoxiazhihu.app;

import android.app.Application;

/**
 * AppContext <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class AppContext extends Application {

    private static AppContext instance;

    protected static AppContext getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setInstance();
        initInject();
    }

    private static void setInstance(){
        instance = new AppContext();
    }
    void initInject(){
        InjectHelp.init(this);
    }
}