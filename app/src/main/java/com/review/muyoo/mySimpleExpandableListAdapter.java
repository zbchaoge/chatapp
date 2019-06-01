package com.review.muyoo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class mySimpleExpandableListAdapter extends BaseExpandableListAdapter {
    private String[] father_content;
    private String[][] child_content;
    private int[][] child_imgId;
    private int mGroupLayout;
    private int mgroup_to;
    private int[] mchild_to;
    private int mChildLayout;

    private LayoutInflater mInflater;

    public mySimpleExpandableListAdapter (Context context,String[] father,String[][] child,int[][] imgId,int fatherLayout,int childLayout,int father_to,int[] child_to){
        father_content = father;
        child_content = child;
        child_imgId = imgId;
        mGroupLayout = fatherLayout;
        mChildLayout = childLayout;
        mgroup_to = father_to;
        mchild_to = child_to;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public Object getChild(int groupPosition, int childPosition) {
        return child_content[groupPosition][childPosition];
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent) {
        View v;
        if (convertView == null) {
            v = newChildView(isLastChild, parent);
        } else {
            v = convertView;
        }
        TextView child_text = v.findViewById(mchild_to[0]);
        child_text.setText((String)child_content[groupPosition][childPosition]);
        ImageView child_img = (ImageView) v.findViewById(mchild_to[1]);
        child_img.setImageResource(child_imgId[groupPosition][childPosition]);
        return v;
    }
    public int getChildrenCount(int groupPosition) {
        return child_content[groupPosition].length;
    }

    public Object getGroup(int groupPosition) {
        return father_content[groupPosition];
    }

    public int getGroupCount() {
        return father_content.length;
    }

    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent) {
        View v;
        if (convertView == null) {
            v = newGroupView(isExpanded, parent);
        } else {
            v = convertView;
        }
        TextView group_text = (TextView) v.findViewById(mgroup_to);
        group_text.setText((String)father_content[groupPosition]);
        return v;
    }
    public View newGroupView(boolean isExpanded, ViewGroup parent) {
        return mInflater.inflate(mGroupLayout, parent, false);
    }
    public View newChildView(boolean isLastChild, ViewGroup parent) {
        return mInflater.inflate(mChildLayout, parent, false);
    }
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public boolean hasStableIds() {
        return true;
    }
}
