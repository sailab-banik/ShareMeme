package com.cyclone.sharememe.util;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.cyclone.sharememe.model.Meme;

import java.util.Objects;

public class MemeComparator extends DiffUtil.ItemCallback<Meme> {
    @Override
    public boolean areItemsTheSame(@NonNull Meme oldItem, @NonNull Meme newItem) {
        return Objects.equals(oldItem.getUrl(), newItem.getUrl());
    }

    @SuppressLint("DiffUtilEquals")
    @Override
    public boolean areContentsTheSame(@NonNull Meme oldItem, @NonNull Meme newItem) {
        return Objects.equals(oldItem.getUrl(), newItem.getUrl());
    }
}
