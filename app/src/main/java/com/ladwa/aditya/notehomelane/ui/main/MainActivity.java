package com.ladwa.aditya.notehomelane.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.ladwa.aditya.notehomelane.R;
import com.ladwa.aditya.notehomelane.data.model.Note;
import com.ladwa.aditya.notehomelane.databinding.ActivityMainBinding;
import com.ladwa.aditya.notehomelane.ui.base.BaseActivity;

import java.util.Date;

import javax.inject.Inject;

import io.realm.RealmResults;

public class MainActivity extends BaseActivity implements MainContract.View {

    @Inject MainPresenter mPresenter;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.attachView(this);
    }

    @Override
    public void setUpView() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(mBinding.toolbar);
        Note newNote = new Note();
        newNote.setTitle("New Title");
        newNote.setText("This is the text for the new Text");
        newNote.setUrl("basicUrl");
        newNote.setCreatedAt(new Date().getTime());
//        mPresenter.createNote(newNote);
        mPresenter.getAllNotes();
    }


    @Override
    public void setProjects(RealmResults<Note> notes) {

    }

    @Override
    public void showEmpty() {

    }
}
