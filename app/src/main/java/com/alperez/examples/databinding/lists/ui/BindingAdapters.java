package com.alperez.examples.databinding.lists.ui;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alperez.examples.databinding.lists.R;
import com.alperez.examples.databinding.lists.model.LeadModel;
import com.alperez.examples.databinding.lists.ui.widget.OnCircleBadgeHolderLayout;
import com.alperez.examples.databinding.lists.utils.AppUtils;
import com.alperez.examples.databinding.lists.utils.Tweakables;

/**
 * Created by stanislav.perchenko on 2/3/2017.
 */

public class BindingAdapters {




    @BindingAdapter({"container_size", "badge_size"})
    public static void setOnCircleBadgeHolderLayout_Sizes(OnCircleBadgeHolderLayout v, float containerSize, float badgeSize) {
        v.setContainerAndBadgeSize(containerSize, badgeSize);
    }

    @BindingAdapter({"imageUrl", "drawable_fallback"})
    public static void setImageView_ContentWithFallback(ImageView iv, String path, Drawable fallback) {
        AppUtils.picassoLoadProtected(iv, path, fallback);
    }

    @BindingAdapter("leadSyncStatusBadge")
    public static void setView_LeadStatusBadge(View v, LeadModel lead) {
        Drawable bg = v.getBackground();
        if (bg != null) {
            if (!lead.fullLead()) {
                bg.setLevel(2);
            } else  if (lead.pendingQualifications()) {
                bg.setLevel(1);
            } else {
                bg.setLevel(0);
            }
        }
    }

    @BindingAdapter("leadSyncStatusDot")
    public static void setView_LeadStatusDot(View v, LeadModel lead) {
        if (lead.pendingQualifications()) {
            v.setVisibility(View.VISIBLE);
            v.getBackground().setLevel(0);
        } else {
            v.setVisibility((lead.qualifications().size() > 0) ? View.VISIBLE : View.INVISIBLE);
            v.getBackground().setLevel(1);
        }
    }



    @BindingAdapter("leadStatusText")
    public static void setTextView_LeadStatusText(TextView tv, LeadModel lead) {
        if (!lead.fullLead()) {
            tv.setText(tv.getContext().getString(R.string.lead_status_saved_local_partial));
            tv.setTextColor(AppUtils.getColorFromResourcesCompat(tv.getContext().getResources(), R.color.lead_ststus_not_synced, null));
        } else {
            if (lead.pendingQualifications()) {
                tv.setText(tv.getContext().getString(R.string.lead_status_saved_local));
                tv.setTextColor(AppUtils.getColorFromResourcesCompat(tv.getContext().getResources(), R.color.lead_ststus_not_synced, null));
            } else {
                tv.setText(tv.getContext().getString(R.string.lead_status_saved));
                tv.setTextColor(AppUtils.getColorFromResourcesCompat(tv.getContext().getResources(), R.color.lead_ststus_ok, null));
            }
        }
    }


    @BindingAdapter({"leadOptPropertyValue", "leadOptPropertyBackup"})
    public static void setTextView_LeadOptionalProperty(TextView tv, String property, String backup) {
        tv.setText(TextUtils.isEmpty(property) ? backup : property);
    }


    @BindingAdapter("leadDebugStatus")
    public static void setTextView_LeadDebugStatus(TextView tv, LeadModel lead) {

        if (Tweakables.DEBUG_TO_UI) {
            tv.setVisibility(View.VISIBLE);
            tv.setText(String.format("Debug: full=%b, pending=%b", lead.fullLead(), lead.pendingQualifications()));
        } else {
            tv.setVisibility(View.GONE);
        }

    }
}
