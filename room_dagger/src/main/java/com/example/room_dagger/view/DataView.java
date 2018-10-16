package com.example.room_dagger.view;

import com.example.room_dagger.model.Intern;

import java.util.List;

public interface DataView {

    void onGetAllInternsSuccesfully(List<Intern> intern);

    void onInternGetSuccesfully(Intern intern);

    void onError(String message);
}
