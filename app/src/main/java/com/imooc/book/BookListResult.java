package com.imooc.book;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class BookListResult {



    @SerializedName("status")
    private int mStatus;
    @SerializedName("msg")
    private String mMessage;


    @SerializedName("data")
    private List<Book> mData;

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int status) {
        mStatus = status;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public List<Book> getData() {
        return mData;
    }

    public void setData(List<Book> data) {
        mData = data;
    }

    public static class Book {
        @SerializedName("bookname")
        private String mBookname;
        @SerializedName("bookfile")
        private String mBookfile;

        public String getBookname() {
            return mBookname;
        }

        public void setBookname(String bookname) {
            mBookname = bookname;
        }

        public String getBookfile() {
            return mBookfile;
        }

        public void setBookfile(String bookfile) {
            mBookfile = bookfile;
        }
    }
}
