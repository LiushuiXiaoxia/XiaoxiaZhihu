package cn.mycommons.xiaoxiazhihu.ui.home;


import javax.inject.Inject;

import cn.mycommons.xiaoxiazhihu.app.InjectHelp;
import cn.mycommons.xiaoxiazhihu.biz.domain.ZhihuDomain;
import cn.mycommons.xiaoxiazhihu.biz.pojo.response.ext.GetThemeResponse;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.BaseMvpPresenter;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.ILoadDataView;
import cn.mycommons.xiaoxiazhihu.ui.base.mvp.IMvpView;
import rx.Observable;


/**
 * OtherThemePresenter <br/>
 * Created by xiaqiulei on 2015-12-30.
 */
public class OtherThemePresenter extends BaseMvpPresenter<OtherThemePresenter.IHomeView> {

    @Inject
    ZhihuDomain zhihuDomain;

    @Override
    public void create(ILoadDataView loadDataView, IHomeView view) {
        super.create(loadDataView, view);

        InjectHelp.appComponent().inject(this);
    }

    Observable<GetThemeResponse> doGetThemById(int id) {
        return zhihuDomain.getThemeById(id);
    }

    interface IHomeView extends IMvpView {

    }
}