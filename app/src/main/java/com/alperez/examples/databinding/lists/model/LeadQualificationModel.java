package com.alperez.examples.databinding.lists.model;

import android.os.Parcelable;

import com.alperez.examples.databinding.lists.utils.JsonUtils;
import com.google.auto.value.AutoValue;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by stanislav.perchenko on 9/7/2016.
 */
@AutoValue
public abstract class LeadQualificationModel extends BaseDbModel implements Parcelable, Cloneable {
    public static final String TABLE_NAME = "Qualifications";

    public static final String COLUMN_LEAD_ID = "lead_id";
    public static final String COLUMN_SELECTOR_ID = "selector_id";
    public static final String COLUMN_VALUE = "selected_value";


    public abstract long leadId();
    public abstract long selectorId();
    public abstract String selectedValue();

    abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_LeadQualificationModel.Builder().setId(0);
    }

    public LeadQualificationModel clone() {
        return builder().setLeadId(leadId()).setSelectorId(selectorId()).setSelectedValue(selectedValue()).build();
    }

    public LeadQualificationModel withNewValue(String selectedValue) {
        return toBuilder().setSelectedValue(selectedValue).build();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setId(long id);
        public abstract Builder setLeadId(long leadId);
        public abstract Builder setSelectorId(long selectorId);
        public abstract Builder setSelectedValue(String selectedValue);

        public abstract LeadQualificationModel build();
    }



    public static LeadQualificationModel fromJson(long leadId, String json) throws JSONException {
        JSONObject jEvent = new JSONObject(json);
        return fromJsonObject(leadId, jEvent);
    }


    public static LeadQualificationModel fromJsonObject(long leadId, JSONObject jObj) throws JSONException {
        try {
            leadId = jObj.getLong(COLUMN_LEAD_ID);
        } catch (JSONException e){}

        return builder()
                .setLeadId(leadId)
                .setSelectorId(jObj.getLong(COLUMN_SELECTOR_ID))
                .setSelectedValue(jObj.getString(COLUMN_VALUE))
                .build();
    }



    public JSONObject toJson() throws JSONException {
        JSONObject ret = new JSONObject();
        ret.put(COLUMN_LEAD_ID, JsonUtils.leadIdToServerValue(leadId()));
        ret.put(COLUMN_SELECTOR_ID, selectorId());
        ret.put(COLUMN_VALUE, selectedValue());
        return ret;
    }
}