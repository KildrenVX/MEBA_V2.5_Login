package com.example.m.meba_v2;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by m on 12/04/2017.
 */

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHea;
    private HashMap<String,List<String>> ListHasMap;

    public ExpandableListAdapter(Context context, List<String> listDataHea, HashMap<String, List<String>> listHasMap) {
        this.context = context;
        this.listDataHea = listDataHea;
        ListHasMap = listHasMap;
    }

    @Override
    public int getGroupCount() {
        return listDataHea.size();
    }


    @Override
    public int getChildrenCount(int i) {

        int a =ListHasMap.get(listDataHea.get(i)).size();
        return a;
    }

    @Override
    public Object getGroup(int i) {
        return listDataHea.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return ListHasMap.get(listDataHea.get(i)).get(i1) ;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean isExpanded, View convertView, ViewGroup parent) {

        String HeadTitle = (String)getGroup(i);
        if (convertView == null )
        {
            LayoutInflater inflater =  (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_gruou,null);
            TextView ListHeads = (TextView)convertView.findViewById(R.id.ListHead);
            ListHeads.setTypeface(null, Typeface.BOLD);
            ListHeads.setText(HeadTitle);
        }
        return convertView;
    }

    @Override
    public View getChildView(int i, int i1, boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText =(String)getChild(i,i1);
        if(convertView==null)
        {
         LayoutInflater inflater=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(R.layout.list_item,null);
        }
        TextView txtLIstChild =(TextView)convertView.findViewById(R.id.ListItem);
        txtLIstChild.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
