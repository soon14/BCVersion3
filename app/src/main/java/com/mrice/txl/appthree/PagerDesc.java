package com.mrice.txl.appthree;

/**
 * Created by cai on 2017/9/12.
 */

public class PagerDesc {

    private int top;
    private int left;
    private int right;
    private int bottom;

    //get set方法

    public PagerDesc(int top, int left, int right, int bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
}
