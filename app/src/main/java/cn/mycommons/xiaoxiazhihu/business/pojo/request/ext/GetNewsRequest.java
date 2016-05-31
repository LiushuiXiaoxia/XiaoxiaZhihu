package cn.mycommons.xiaoxiazhihu.business.pojo.request.ext;

import cn.mycommons.xiaoxiazhihu.business.pojo.request.BaseRequest;

/**
 * GetNewsRequest <br/>
 * Created by xiaqiulei on 2016-01-04.
 */
public class GetNewsRequest extends BaseRequest {

    private int id;

    public GetNewsRequest(int id) {
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
        return "GetNewsRequest{" +
                "id=" + id +
                "} " + super.toString();
    }
}