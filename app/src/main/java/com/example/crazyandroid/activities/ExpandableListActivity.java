package com.example.crazyandroid.activities;
import com.example.crazyandroid.R;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ExpandableListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable_list);
        ExpandableListAdapter adapter = new ExpandableListAdapter() {
            int[] logos = new int[]{
                    android.R.drawable.ic_btn_speak_now,
                    android.R.drawable.ic_lock_idle_low_battery,
                    android.R.drawable.ic_lock_idle_alarm
            };
            private String[] armTypes = new String[] {
                    "ShenZu", "ChongZu", "RenZu"
            };
            private String[][] arms = new String[][] {
                    {"KuangZhanShi", "LongQiShi", "HeiAnShengTang", "DianBing"},
                    {"XiaoGou", "CiShe", "FeiLong", "ZiBaoFeiJi"},
                    {"JiQiangGou", "HushiMM", "YouLing"}
            };

            @Override
            public void registerDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

            }

            @Override
            public int getGroupCount() {
                return armTypes.length;
            }

            @Override
            public int getChildrenCount(int i) {
                return arms[i].length;
            }

            @Override
            public Object getGroup(int i) {
                return armTypes[i];
            }

            @Override
            public Object getChild(int i, int i1) {
                return arms[i][i1];
            }

            @Override
            public long getGroupId(int i) {
                return i;
            }

            @Override
            public long getChildId(int i, int i1) {
                return i1;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
                LinearLayout ll = new LinearLayout(ExpandableListActivity.this);
                ll.setOrientation(LinearLayout.VERTICAL);
                ImageView logo = new ImageView(ExpandableListActivity.this);
                logo.setImageResource(logos[i]);
                ll.addView(logo);
                TextView textView = getTextView();
                textView.setText(getGroup(i).toString());
                ll.addView(textView);
                return ll;
            }

            private TextView getTextView() {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
                TextView textView = new TextView(ExpandableListActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                return textView;
            }

            @Override
            public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
                TextView textView = getTextView();
                textView.setText(getChild(i, i1).toString());
                return textView;
            }

            @Override
            public boolean isChildSelectable(int i, int i1) {
                return true;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public void onGroupExpanded(int i) {

            }

            @Override
            public void onGroupCollapsed(int i) {

            }

            @Override
            public long getCombinedChildId(long l, long l1) {
                return 0;
            }

            @Override
            public long getCombinedGroupId(long l) {
                return 0;
            }
        };
        ExpandableListView expandableListView = (ExpandableListView)findViewById(R.id.mylist);
        expandableListView.setAdapter(adapter);
    }
}
