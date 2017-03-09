package com.alperez.examples.databinding.lists.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alperez.examples.databinding.lists.R;
import com.alperez.examples.databinding.lists.databinding.ActivityLeadDetailsBinding;
import com.alperez.examples.databinding.lists.model.LeadModel;

/**
 * This is the only part of the original activity. All edit-related features were removed.
 *
 * Created by stanislav.perchenko on 3/1/2017.
 */

public class LeadDetailsActivity extends AppCompatActivity {

    public static String ARG_LEAD = "lead";

    ActivityLeadDetailsBinding binding;


    private LeadModel mLead;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLead = getArgLead();
        if (mLead == null) {
            setResult(RESULT_CANCELED);
            finish();
            return;
        }


        binding = DataBindingUtil.setContentView(this, R.layout.activity_lead_details);
        binding.setModel(mLead);

    }





    private LeadModel getArgLead() {
        Intent i = getIntent();
        if (i.hasExtra("other_key")) {
            return i.getParcelableExtra("other_key");
        } else if (i.hasExtra(ARG_LEAD)) {
            return i.getParcelableExtra(ARG_LEAD);
        } else {
            return null;
        }

    }
}
