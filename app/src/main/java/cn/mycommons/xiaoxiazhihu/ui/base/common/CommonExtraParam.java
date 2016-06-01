package cn.mycommons.xiaoxiazhihu.ui.base.common;


import android.app.Activity;
import android.content.Intent;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import cn.mycommons.xiaoxiazhihu.app.IValidate;


/**
 * Created by xiaqiulei on 14/11/20.
 */
public class CommonExtraParam implements Serializable, IValidate {

    private static final Logger LOGGER = Logger.getLogger(CommonExtraParam.class.getName());

    public static <R extends CommonExtraParam> R getReqExtraParam(Activity activity) {
        try {
            return (R) activity.getIntent().getSerializableExtra(ICommonFragment.EXTRA_REQ);
        } catch (Exception e) {
            LOGGER.log(Level.INFO,e.toString());
            return null;
        }
    }

    public static <R extends CommonExtraParam> R getRespExtraParam(Intent data) {
        if (data != null) {
            return (R) data.getSerializableExtra(ICommonFragment.EXTRA_RESP);
        }
        return null;
    }

    /// ************************************************************************************************************

    private Class<? extends ICommonFragment> fragmentClass;

    private Class<? extends Activity> activityClass;

    private String uri;

    public CommonExtraParam() {
    }

    public CommonExtraParam(Class<? extends ICommonFragment> fragmentClass) {
        this.fragmentClass = fragmentClass;
    }

    public CommonExtraParam(Class<? extends ICommonFragment> fragmentClass, Class<? extends Activity> activityClass) {
        this.fragmentClass = fragmentClass;
        this.activityClass = activityClass;
    }

    public Class<? extends ICommonFragment> getFragmentClass() {
        return fragmentClass;
    }

    public void setFragmentClass(Class<? extends ICommonFragment> fragmentClass) {
        this.fragmentClass = fragmentClass;
    }

    public Class<? extends Activity> getActivityClass() {
        return activityClass;
    }

    public void setActivityClass(Class<? extends Activity> activityClass) {
        this.activityClass = activityClass;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public boolean validate() {
        return fragmentClass != null;
    }

    public String toString() {
        return "CommonExtraParam{" +
                "fragmentClass=" + fragmentClass +
                ", activityClass=" + activityClass +
                ", uri='" + uri + '\'' +
                '}';
    }
}