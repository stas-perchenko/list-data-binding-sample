package com.alperez.examples.databinding.lists.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.alperez.examples.databinding.lists.R;
import com.alperez.examples.databinding.lists.ui.adapter.LeadListAdapter;
import com.alperez.examples.databinding.lists.utils.AppUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LeadListAdapter ad = new LeadListAdapter(this, AppUtils.getTestData());
        ad.setOnLeadItemClickListener(lead -> {
            Intent intent = new Intent(this, LeadDetailsActivity.class).putExtra(LeadDetailsActivity.ARG_LEAD, lead);
            startActivity(intent);
        });

        ((ListView) findViewById(R.id.lead_list)).setAdapter(ad);
    }
}
