package com.webforj.howdy.views;

import com.webforj.howdy.components.Explore;

import com.webforj.component.Composite;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/you", outlet = MainLayout.class)
@FrameTitle("You")
public class YouView extends Composite<FlexLayout> {
  private FlexLayout self = getBoundComponent();

  public YouView() {
    self.setHeight("100%");
    self.setAlignment(FlexAlignment.CENTER);
  }
}
