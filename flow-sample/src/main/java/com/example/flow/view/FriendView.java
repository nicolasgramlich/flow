/*
 * Copyright 2013 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.flow.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.example.flow.R;
import com.example.flow.Screens;
import com.example.flow.appflow.AppFlow;
import com.example.flow.util.Utils;
import com.example.flow.model.User;
import java.util.List;
import javax.inject.Inject;

public class FriendView extends FrameLayout {
  @Inject List<User> friends;

  private final User friend;

  @InjectView(R.id.friend_info) TextView friendInfo;

  public FriendView(Context context, AttributeSet attrs) {
    super(context, attrs);
    Utils.inject(context, this);

    Screens.Friend screen = AppFlow.getScreen(context);
    friend = friends.get(screen.index);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    ButterKnife.inject(this);
    friendInfo.setText("Name: " + friend.name);
  }
}
