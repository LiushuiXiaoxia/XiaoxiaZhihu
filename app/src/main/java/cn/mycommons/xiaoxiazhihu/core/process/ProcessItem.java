package cn.mycommons.xiaoxiazhihu.core.process;


import java.util.logging.Level;
import java.util.logging.Logger;

import cn.mycommons.xiaoxiazhihu.core.log.XLog;

/**
 * ProcessItem <br/>
 * Created by xiaqiulei on 2015-08-12.
 */
public class ProcessItem<P> {

    private static final Logger LOGGER = Logger.getLogger(ProcessItem.class.getName());
    String key;

    IProcess<P> process;

    Class<IProcess<P>> processClass;

    boolean isNewInstance; // 是否单个实例运行

    public ProcessItem(String key) {
        this.key = key;
    }

    public ProcessItem<P> setProcess(IProcess<P> process) {
        this.process = process;

        return this;
    }

    public ProcessItem<P> setProcess(Class<IProcess<P>> processClass, boolean isNewInstance) {
        this.processClass = processClass;
        this.isNewInstance = isNewInstance;

        return this;
    }

    public void doProcess(P param) {
        try {
            if (process != null) {
                process.process(key, param);
            } else {
                if (processClass != null) {
                    IProcess<P> temp = processClass.newInstance();
                    if (temp != null) {
                        temp.process(key, param);
                    }

                    if (temp != null && !isNewInstance) {
                        process = temp;
                    }
                }
            }
        } catch (Exception e) {
            XLog.i("process key = %s, param = %s fail", key, param);
            LOGGER.log(Level.WARNING,e.toString());
        }
    }
}