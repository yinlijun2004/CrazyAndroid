package com.example.crazyandroid.activities;
import com.example.crazyandroid.R;

import android.app.Activity;
import android.os.Bundle;

public class FragementTestMainActivity extends Activity implements BookListFragment.Callbacks{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_twopane);
    }

    @Override
    public void onItemSelected(Integer id) {
        Bundle arguments = new Bundle();
        arguments.putInt(BookDetailFragment.ITEM_ID, id);
        BookDetailFragment fragment = new BookDetailFragment();
        fragment.setArguments(arguments);
        getFragmentManager().beginTransaction().replace(R.id.book_detail_container, fragment).commit();
    }
}
