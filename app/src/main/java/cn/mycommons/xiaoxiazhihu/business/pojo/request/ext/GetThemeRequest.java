package cn.mycommons.xiaoxiazhihu.business.pojo.request.ext;

import cn.mycommons.xiaoxiazhihu.business.pojo.request.BaseRequest;

/**
 * GetThemeRequest <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class GetThemeRequest extends BaseRequest {

    private int id;

    public GetThemeRequest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GetThemeRequest{" +
                "id=" + id +
                "} " + super.toString();
    }
}