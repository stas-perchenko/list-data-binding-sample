package com.alperez.examples.databinding.lists.model;

import android.support.annotation.NonNull;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;

/**
 * Created by stanislav.perchenko on 9/7/2016.
 */
public class SettingsModel<T> extends BaseDbModel {
    public static final String TABLE_NAME = "Settings";
    public static final String COLUMN_ID = "selector_id";
    public static final String COLUMN_NAME = "selector_name";
    public static final String COLUMN_TYPE = "selector_type";
    public static final String COLUMN_OPTIONS = "selection_variants";


    private long id;
    private String selectorName;
    private T[] options;
    private Class<?> type;

    public static SettingsModel<?> fromJson(JSONObject jSetting) throws JSONException {
        String type = jSetting.getString(COLUMN_TYPE);
        long id = jSetting.getLong(COLUMN_ID);

        SettingsModel model = null;
        JSONArray jOpts = jSetting.getJSONArray(COLUMN_OPTIONS);
        if (type.equals("text")) {
            SettingsModel<String> mStr = new SettingsModel<String>(id);
            mStr.options = new String[jOpts.length()];
            for (int i=0; i<mStr.options.length; i++) {
                mStr.options[i] = jOpts.getString(i);
            }
            mStr.type = String.class;
            model = mStr;
        } else if (type.equals("int")) {
            SettingsModel<Integer> mInt = new SettingsModel<Integer>(id);
            mInt.options = new Integer[jOpts.length()];
            for (int i=0; i<mInt.options.length; i++) {
                mInt.options[i] = jOpts.getInt(i);
            }
            mInt.type = Integer.class;
            model = mInt;
        } else {
            throw new JSONException("Wring selector_type parameter. Must be 'int' or 'text'. Got - "+type);
        }
        model.selectorName = jSetting.getString(COLUMN_NAME);
        return model;
    }

    public SettingsModel(long id) {
        this.id = id;
    }

    @SuppressWarnings("unchecked")
    public SettingsModel(SettingsModel<T> source) {
        this.id = source.id;
        this.selectorName = source.selectorName;
        this.type = source.type;
        if (source.options != null) {
            this.options =(T[]) Array.newInstance(this.type, source.options.length);
            System.arraycopy(source.options, 0, this.options, 0, this.options.length);
        }
        String s = this.options.toString();
    }


    /**
     * This cunstructor is used to restore instance from DB.
     * @param typeName full class name for parametrization. May be java.lang.Integer or java.lang.String
     * @param selectorName
     * @param jOptions
     */
    @SuppressWarnings("unchecked")
    public SettingsModel(long id, String typeName, String selectorName, JSONArray jOptions) throws ClassNotFoundException, JSONException {
        this.id = id;
        this.type = Class.forName(typeName);
        this.selectorName = selectorName;
        this.options = (T[])Array.newInstance(type, jOptions.length());
        if (type == String.class) {
            for (int i=0; i<options.length; i++) {
                options[i] = (T)jOptions.getString(i);
            }
        } else if (type == Integer.class) {
            for (int i=0; i<options.length; i++) {
                options[i] = (T)Integer.valueOf(jOptions.getInt(i));
            }
        } else {
            throw new ClassNotFoundException("Only Integer and String types are supported for options");
        }
    }


    public String getSelectorName() {
        return selectorName;
    }

    public T[] getOptions() {
        return options;
    }

    public Class<?> getType() {
        return type;
    }

    public int getIndexOfSelectedValue(@NonNull String selectedValue) {
        int index = -1;
        for (int i=0; i<options.length; i++) {
            if (selectedValue.equals(options[i].toString())) {
                index = i; break;
            }
        }
        return index;
    }

    @Override
    public long id() {
        return id;
    }

    @Override
    public SettingsModel<T> clone() {
        SettingsModel<T> nObj = new SettingsModel<>(id);
        nObj.selectorName = this.selectorName;
        nObj.type = this.type;
        nObj.options = (T[])new Object[this.options.length];
        System.arraycopy(this.options, 0, nObj.options, 0, this.options.length);
        return nObj;
    }
}
