package cn.mycommons.xiaoxiazhihu.business.pojo.request.ext;

import cn.mycommons.xiaoxiazhihu.business.pojo.request.BaseRequest;

/**
 * StartInfoRequest <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class GetStartInfoRequest extends BaseRequest {

    private int width;

    private  int height;

    public GetStartInfoRequest(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "StartInfoRequest{" +
                "width=" + width +
                ", height=" + height +
                "} " + super.toString();
    }
}