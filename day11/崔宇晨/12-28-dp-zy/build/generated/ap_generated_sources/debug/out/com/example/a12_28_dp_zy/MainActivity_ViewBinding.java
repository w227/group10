// Generated code from Butter Knife. Do not modify!
package com.example.a12_28_dp_zy;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.tabs.TabLayout;
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

    target.mTbTxt = Utils.findRequiredViewAsType(source, R.id.tb_txt, "field 'mTbTxt'", TextView.class);
    target.mTb = Utils.findRequiredViewAsType(source, R.id.tb, "field 'mTb'", Toolbar.class);
    target.mImg = Utils.findRequiredViewAsType(source, R.id.img, "field 'mImg'", ImageView.class);
    target.mTxt = Utils.findRequiredViewAsType(source, R.id.txt, "field 'mTxt'", TextView.class);
    target.mImg2 = Utils.findRequiredViewAsType(source, R.id.img2, "field 'mImg2'", ImageView.class);
    target.mImg3 = Utils.findRequiredViewAsType(source, R.id.img3, "field 'mImg3'", ImageView.class);
    target.mRel = Utils.findRequiredViewAsType(source, R.id.rel, "field 'mRel'", RecyclerView.class);
    target.mRel2 = Utils.findRequiredViewAsType(source, R.id.rel2, "field 'mRel2'", RecyclerView.class);
    target.mImg4 = Utils.findRequiredViewAsType(source, R.id.img4, "field 'mImg4'", ImageView.class);
    target.mTab = Utils.findRequiredViewAsType(source, R.id.tab, "field 'mTab'", TabLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTbTxt = null;
    target.mTb = null;
    target.mImg = null;
    target.mTxt = null;
    target.mImg2 = null;
    target.mImg3 = null;
    target.mRel = null;
    target.mRel2 = null;
    target.mImg4 = null;
    target.mTab = null;
  }
}
