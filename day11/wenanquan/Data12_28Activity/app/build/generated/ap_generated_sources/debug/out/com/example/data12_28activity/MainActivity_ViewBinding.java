// Generated code from Butter Knife. Do not modify!
package com.example.data12_28activity;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.youth.banner.Banner;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.toolbarMain = Utils.findRequiredViewAsType(source, R.id.toolbar_main, "field 'toolbarMain'", Toolbar.class);
    target.bannerMain = Utils.findRequiredViewAsType(source, R.id.banner_main, "field 'bannerMain'", Banner.class);
    target.rvHai = Utils.findRequiredViewAsType(source, R.id.rv_hai, "field 'rvHai'", RecyclerView.class);
    target.rvGuo = Utils.findRequiredViewAsType(source, R.id.rv_guo, "field 'rvGuo'", RecyclerView.class);
    target.clGuo = Utils.findRequiredViewAsType(source, R.id.cl_guo, "field 'clGuo'", ConstraintLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.toolbarMain = null;
    target.bannerMain = null;
    target.rvHai = null;
    target.rvGuo = null;
    target.clGuo = null;
  }
}
