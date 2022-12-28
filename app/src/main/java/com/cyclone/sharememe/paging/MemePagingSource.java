package com.cyclone.sharememe.paging;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.paging.PagingState;
import androidx.paging.rxjava3.RxPagingSource;

import com.cyclone.sharememe.api.ApiClient;
import com.cyclone.sharememe.model.Meme;
import com.cyclone.sharememe.model.MemeResponse;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MemePagingSource extends RxPagingSource<Integer, Meme> {

    @Nullable
    @Override
    public Integer getRefreshKey(@NonNull PagingState<Integer, Meme> pagingState) {
        return null;
    }

    @NonNull
    @Override
    public Single<LoadResult<Integer, Meme>> loadSingle(@NonNull LoadParams<Integer> loadParams) {
        try {
            int page = loadParams.getKey() != null ? loadParams.getKey() : 1;

            return ApiClient.getApiInterface()
                    .getMemesByPage(page)
                    .subscribeOn(Schedulers.io())
                    .map(MemeResponse :: getMemes)
                    .map(memes -> toLoadResult(memes, page))
                    .onErrorReturn(LoadResult.Error :: new);
        } catch (Exception e) {
            return Single.just(new LoadResult.Error(e));
        }
    }
    private LoadResult<Integer, Meme> toLoadResult(List<Meme> memes, int page) {
        return new LoadResult.Page(memes, page == 1 ? null : page-1 , page+1);
    }
}
