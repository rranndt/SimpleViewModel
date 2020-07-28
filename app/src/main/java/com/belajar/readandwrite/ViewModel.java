package com.belajar.readandwrite;

import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel implements Number {

//    private Integer mScore;

    private MutableLiveData<Integer> mScore;

    public MutableLiveData<Integer> getmScore() {
        if (mScore == null) {
            mScore = new MutableLiveData<>();
            mScore.setValue(0);
//            mScore.postValue(); // This isi called from a worker thread
        }
        return mScore;
    }

//    public Integer getmScore() {
//        if (mScore == null) {
//            mScore = 0;
//        }
//        return mScore;
//    }

    @Override
    public void decrement() {
        if (mScore.getValue() != null) {
            mScore.setValue(mScore.getValue() - 1);
        }
//        if (mScore == null) {
//            mScore = 0;
//        }
//        mScore--;
    }

    @Override
    public void increment() {
        if (mScore.getValue() != null) {
            mScore.setValue(mScore.getValue() + 1);
        }
//        if (mScore == null) {
//            mScore = 0;
//        }
//        mScore++;
    }

    @Override
    public void reset() {
//        mScore = 0;
        mScore.setValue(0);
    }
}
