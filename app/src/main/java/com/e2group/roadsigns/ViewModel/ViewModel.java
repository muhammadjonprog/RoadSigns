package com.e2group.roadsigns.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.e2group.roadsigns.Model.CategoriesSign;
import com.e2group.roadsigns.Model.Repository;

import java.util.List;

public class ViewModel extends AndroidViewModel {

    Repository repository;
    public LiveData<List<CategoriesSign>> allSign;
    public ViewModel(@NonNull Application context) {
        super(context);
        repository = new Repository(context);
        allSign = repository.getAllArticles();
    }

    public LiveData<List<CategoriesSign>> getAllArticles() {
        return allSign;
    }
}