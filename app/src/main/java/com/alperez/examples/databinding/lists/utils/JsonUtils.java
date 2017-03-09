package com.alperez.examples.databinding.lists.utils;

import com.alperez.examples.databinding.lists.model.LeadModel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by stanislav.perchenko on 9/14/2016.
 */
public class JsonUtils {

    public static String leadIdToServerValue(LeadModel lead) {
        return Long.toHexString(lead.id()).toUpperCase();
    }

    public static String leadIdToServerValue(long leadId) {
        return Long.toHexString(leadId).toUpperCase();
    }

    public static long leadIdFromJson(JSONObject jLead, String fieldName) throws JSONException {
        return Long.parseLong(jLead.getString(fieldName), 16);
    }


    /**********************************************************************************************/
    private static final String STRING_VALUE_NULL = "null";

    public static String optJSONString(JSONObject jObj, String key) {
        String s = jObj.optString(key, null);
        if ((s != null) && (s.equalsIgnoreCase(STRING_VALUE_NULL))) {
            s = null;
        }
        return s;
    }

}

