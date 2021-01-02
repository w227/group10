package com.example.a12_28_dp_zy;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class RxOprtroImpl_MembersInjector implements MembersInjector<RxOprtroImpl> {
  private final Provider<APiService> aPiServiceProvider;

  public RxOprtroImpl_MembersInjector(Provider<APiService> aPiServiceProvider) {
    assert aPiServiceProvider != null;
    this.aPiServiceProvider = aPiServiceProvider;
  }

  public static MembersInjector<RxOprtroImpl> create(Provider<APiService> aPiServiceProvider) {
    return new RxOprtroImpl_MembersInjector(aPiServiceProvider);
  }

  @Override
  public void injectMembers(RxOprtroImpl instance) {
    if (instance == null) {
      throw new NullPointerException("Cannot inject members into a null reference");
    }
    instance.aPiService = aPiServiceProvider.get();
  }

  public static void injectAPiService(
      RxOprtroImpl instance, Provider<APiService> aPiServiceProvider) {
    instance.aPiService = aPiServiceProvider.get();
  }
}
