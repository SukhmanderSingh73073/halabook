package com.aps.halabook.util;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aps.halabook.R;

public class Utility {

    public static void addBottomDots(int size , int currentPage , LinearLayout dotsLayout , Context context) {
        TextView[] mTxvDotsArray = new TextView[size];
        dotsLayout.removeAllViews();
        for (int i = 0; i < mTxvDotsArray.length; i++) {
            mTxvDotsArray[i] = new TextView(context);
            mTxvDotsArray[i].setText(Html.fromHtml("&#8226;"));
            mTxvDotsArray[i].setTextSize(35);
            mTxvDotsArray[i].setTextColor(context.getResources().getColor(android.R.color.darker_gray));
            dotsLayout.addView(mTxvDotsArray[i]);
        }
        if (mTxvDotsArray.length > 0)
            mTxvDotsArray[currentPage].setTextColor(context.getResources().getColor(R.color.gray));
    }
}
