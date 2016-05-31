package cn.mycommons.xiaoxiazhihu.core.log;

import android.util.Log;

/**
 * XLog <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class XLog {

    static final String XIAOXIA_ZHIHU = "XiaoxiaZhihu";
    private XLog(){}

    public static int v(String msg, Object... args) {
        if (args != null && args.length != 0) {
            msg = String.format(msg, args);
        }
        return Log.v(XIAOXIA_ZHIHU, msg);
    }

    public static int d(String msg, Object... args) {
        if (args != null && args.length != 0) {
            msg = String.format(msg, args);
        }
        return Log.d(XIAOXIA_ZHIHU, msg);
    }

    public static int i(String msg, Object... args) {
        if (args != null && args.length != 0) {
            msg = String.format(msg, args);
        }
        return Log.i(XIAOXIA_ZHIHU, msg);
    }

    public static int w(String msg, Object... args) {
        if (args != null && args.length != 0) {
            msg = String.format(msg, args);
        }
        return Log.w(XIAOXIA_ZHIHU, msg);
    }

    public static int w(Throwable tr) {
        return Log.w(XIAOXIA_ZHIHU, tr);
    }

    public static int e(String msg, Object... args) {
        if (args != null && args.length != 0) {
            msg = String.format(msg, args);
        }
        return Log.e(XIAOXIA_ZHIHU, msg);
    }

    public static int e(String msg, Throwable tr) {
        return Log.e(XIAOXIA_ZHIHU, msg, tr);
    }
}