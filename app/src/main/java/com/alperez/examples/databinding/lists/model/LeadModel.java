package com.alperez.examples.databinding.lists.model;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.alperez.examples.databinding.lists.utils.JsonUtils;
import com.google.auto.value.AutoValue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by stanislav.perchenko on 9/7/2016.
 */
@AutoValue
public abstract class LeadModel extends BaseDbModel implements Parcelable, Cloneable {
    public static final String TABLE_NAME = "Leads";
    public static final String COLUMN_ID = "visitor_id";
    public static final String COLUMN_EVENT_ID = "event_id";
    public static final String COLUMN_EVENT_CODE = "event_code";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_COMPANY = "company";
    public static final String COLUMN_FACEBOOK = "facebook";
    public static final String COLUMN_PHOTO = "photo";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_POSITION = "position";
    public static final String COLUMN_QUALIFICATIONS_PENDING = "qualif_pending";
    public static final String COLUMN_FULL_LEAD = "full_lead";



    public abstract long eventId();
    @Nullable
    public abstract String eventCode();
    @Nullable public abstract String name();
    @Nullable public abstract String company();
    @Nullable public abstract String facebookUrl();
    @Nullable public abstract String photoUrl();
    @Nullable public abstract String phone();
    @Nullable public abstract String email();
    @Nullable public abstract String position();
    public abstract boolean pendingQualifications();
    public abstract boolean fullLead();
    public abstract ArrayList<LeadQualificationModel> qualifications();


    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_LeadModel.Builder();
    }

    public LeadModel clone() {
        ArrayList<LeadQualificationModel> nQuals = new ArrayList<>(qualifications().size());
        nQuals.addAll(qualifications());

        return builder()
                .setId(id())
                .setEventId(eventId())
                .setEventCode(eventCode())
                .setName(name())
                .setCompany(company())
                .setFacebookUrl(facebookUrl())
                .setPhotoUrl(photoUrl())
                .setPhone(phone())
                .setEmail(email())
                .setPosition(position())
                .setPendingQualifications(pendingQualifications())
                .setFullLead(fullLead())
                .setQualifications(nQuals)
                .build();
    }

    public LeadModel withQualifications(@NonNull ArrayList<LeadQualificationModel> qualifs) {
        return toBuilder().setQualifications(qualifs).build();
    }

    public LeadModel withUpdatedPendingQualificationsStatus(boolean pending) {
        return toBuilder().setPendingQualifications(pending).build();
    }

    public LeadModel withUpdatedFullLeadProperty(boolean fullLead) {
        return toBuilder().setFullLead(fullLead).build();
    }

    public LeadModel withServerPropertiesOfAnotherLead(LeadModel other) {
        return this.toBuilder()
                .setEventId(other.eventId())
                .setEventCode(other.eventCode())
                .setCompany(other.company())
                .setName(other.name())
                .setFacebookUrl(other.facebookUrl())
                .setPhotoUrl(other.photoUrl())
                .setPhone(other.phone())
                .setEmail(other.email())
                .setPosition(other.position())
                .build();
    }


    @Nullable
    public LeadQualificationModel qualificationForSetting(SettingsModel sMod) {
        for (LeadQualificationModel lqm : qualifications()) {
            if (lqm.selectorId() == sMod.id()) {
                return lqm;
            }
        }
        return null;
    }



    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setId(long id);
        public abstract Builder setEventId(long eventId);
        public abstract Builder setEventCode(String eventCode);
        public abstract Builder setName(String name);
        public abstract Builder setCompany(String company);
        public abstract Builder setFacebookUrl(String facebookUrl);
        public abstract Builder setPhotoUrl(String photoUrl);
        public abstract Builder setPhone(String phone);
        public abstract Builder setEmail(String email);
        public abstract Builder setPosition(String position);
        public abstract Builder setPendingQualifications(boolean pendingQualifications);
        public abstract Builder setFullLead(boolean fullLead);
        public abstract Builder setQualifications(ArrayList<LeadQualificationModel> qualifications);


        public abstract LeadModel build();
    }




    public static LeadModel fromJson(String json) throws JSONException {
        JSONObject jLead = new JSONObject(json);
        return fromJsonObject(jLead);
    }

    public static LeadModel fromJsonObject(JSONObject jLead) throws JSONException {
        long leadId = JsonUtils.leadIdFromJson(jLead, COLUMN_ID);

        ArrayList<LeadQualificationModel> qualifs;

        JSONArray jQualif = jLead.optJSONArray("qualifications");
        if (jQualif != null) {
            qualifs = new ArrayList<>(jQualif.length());
            for (int i=0; i < jQualif.length(); i++) {
                qualifs.add(LeadQualificationModel.fromJsonObject(leadId, jQualif.getJSONObject(i)));
            }
        } else {
            qualifs = new ArrayList<>();
        }

        return builder()
                .setId(leadId)
                .setEventId(jLead.getLong(COLUMN_EVENT_ID))
                .setEventCode(jLead.getString(COLUMN_EVENT_CODE))
                .setName(JsonUtils.optJSONString(jLead, COLUMN_NAME))
                .setCompany(JsonUtils.optJSONString(jLead, COLUMN_COMPANY))
                .setFacebookUrl(JsonUtils.optJSONString(jLead, COLUMN_FACEBOOK))
                .setPhotoUrl(JsonUtils.optJSONString(jLead, COLUMN_PHOTO))
                .setPhone(JsonUtils.optJSONString(jLead, COLUMN_PHONE))
                .setEmail(JsonUtils.optJSONString(jLead, COLUMN_EMAIL))
                .setPosition(JsonUtils.optJSONString(jLead, COLUMN_POSITION))
                .setPendingQualifications(false)
                .setFullLead(true)
                .setQualifications(qualifs)
                .build();

    }
}
