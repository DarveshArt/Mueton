package com.darveshart.app.friend;

import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import java.util.List;

/**
 * Created by zamee on 11/16/2017.
 */

public class MessageListDiffCall extends DiffUtil.Callback {

        private final List<BaseMessage> mOldEmployeeList;
        private final List<BaseMessage> mNewEmployeeList;

        public MessageListDiffCall(List<BaseMessage> oldEmployeeList, List<BaseMessage> newEmployeeList) {
            this.mOldEmployeeList = oldEmployeeList;
            this.mNewEmployeeList = newEmployeeList;
        }

        @Override
        public int getOldListSize() {
            return mOldEmployeeList.size();
        }

        @Override
        public int getNewListSize() {
            return mNewEmployeeList.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return false;

                    //mOldEmployeeList.get(oldItemPosition).getBitmap() == mNewEmployeeList.get(
                   // newItemPosition).getBitmap();
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            final BaseMessage oldEmployee = mOldEmployeeList.get(oldItemPosition);
            final BaseMessage newEmployee = mNewEmployeeList.get(newItemPosition);

            return false;
            //oldEmployee.getBitmap().equals(newEmployee.getBitmap());
        }

        @Nullable
        @Override
        public Object getChangePayload(int oldItemPosition, int newItemPosition) {
            // Implement method if you're going to use ItemAnimator
            return super.getChangePayload(oldItemPosition, newItemPosition);
        }

    }