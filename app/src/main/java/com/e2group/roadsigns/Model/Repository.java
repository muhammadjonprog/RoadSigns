package com.e2group.roadsigns.Model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    private SignDao signDao;
    private LiveData<List<CategoriesSign>> allSign;

    public Repository(Application application){
        SignDatabase dataBase = SignDatabase.getInstance(application);
        signDao = dataBase.signDao();
        allSign = signDao.getAll();
    }
    public LiveData<List<CategoriesSign>> getAllArticles(){
        return allSign;
    }
}
