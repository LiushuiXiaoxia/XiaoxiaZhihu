package cn.mycommons.xiaoxiazhihu.business.pojo.request.ext;

import cn.mycommons.xiaoxiazhihu.business.pojo.request.BaseRequest;

/**
 * GetLongCommentsRequest <br/>
 * Created by xiaqiulei on 2016-01-05.
 */
public class GetLongCommentsRequest extends BaseRequest {

    private int id;

    public GetLongCommentsRequest(int id) {
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
        return "GetLongCommentsRequest{" +
                "id=" + id +
                "} " + super.toString();
    }
}