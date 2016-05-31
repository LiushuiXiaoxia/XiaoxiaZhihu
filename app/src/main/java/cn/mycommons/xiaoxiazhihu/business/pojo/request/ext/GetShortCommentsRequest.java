package cn.mycommons.xiaoxiazhihu.business.pojo.request.ext;

import cn.mycommons.xiaoxiazhihu.business.pojo.request.BaseRequest;

/**
 * GetShortCommentsRequest <br/>
 * Created by xiaqiulei on 2016-01-05.
 */
public class GetShortCommentsRequest extends BaseRequest {

    private int id;

    public GetShortCommentsRequest(int id) {
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
        return "GetShortCommentsRequest{" +
                "id=" + id +
                "} " + super.toString();
    }
}
