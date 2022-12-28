package com.cyclone.sharememe.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.rxjava3.PagingRx;

import io.reactivex.rxjava3.core.Flowable;
import kotlinx.coroutines.CoroutineScope;

import com.cyclone.sharememe.model.Meme;
import com.cyclone.sharememe.paging.MemePagingSource;

public class MemeViewModel extends ViewModel {

    public Flowable<PagingData<Meme>> memePagingDataFlowable;

    public MemeViewModel() {
        init();
    }

    private void init() {

        // Paging Source
        MemePagingSource memePagingSource = new MemePagingSource();

        Pager<Integer, Meme> pager = new Pager(
                new PagingConfig(
                        20,
                        20,
                        false,
                        20,
                        20*499
                ),
                () -> memePagingSource);

        // Flowable
        memePagingDataFlowable = PagingRx.getFlowable(pager);
        CoroutineScope coroutineScope = ViewModelKt.getViewModelScope(this);
        PagingRx.cachedIn(memePagingDataFlowable, coroutineScope);
    }
}
