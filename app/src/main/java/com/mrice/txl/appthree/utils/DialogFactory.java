package com.mrice.txl.appthree.utils;

import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;

import com.mrice.txl.appthree.view.ProgressDialog;
import com.mrice.txl.appthree.view.dialog.AlertDialog;
import com.mrice.txl.appthree.view.dialog.BaseDialog;

/**
 * Created by cai on 2015/11/20.
 */
public class DialogFactory {
    public static ProgressDialog createProgressDialog(FragmentActivity context, String msg) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(msg);
        return progressDialog;
    }

    public static ProgressDialog createDialogWithNoMessage(FragmentActivity context) {
        return createProgressDialog(context, "");
    }


    public static BaseDialog createFullContentDialog(FragmentActivity context, String title, String okString,
                                                     String cancelString, String content,
                                                     final DialogInterface.OnClickListener positiveListener,
                                                     final DialogInterface.OnClickListener negativeListener) {
        AlertDialog.AlertDialogDelegate listener = new AlertDialog.AlertDialogDelegate() {
            @Override
            public void onButtonClick(AlertDialog dialog, View view, int index) {
                switch (index) {
                    case 0: {
                        if (positiveListener != null) {
                            positiveListener.onClick(
                                    dialog.getDialog(), index
                            );
                        }
                        break;
                    }
                    case 1: {
                        if (negativeListener != null) {
                            negativeListener.onClick(
                                    dialog.getDialog(), index
                            );
                        }
                        break;
                    }
                }
            }
        };
        BaseDialog dialog = createAlertDialog(
                context, title, content, listener, okString, cancelString
        );
        return dialog;
    }

    public static BaseDialog createAlertDialog(FragmentActivity context, String title,
                                               String message,
                                               AlertDialog.AlertDialogDelegate listener,
                                               String... btns) {
        AlertDialog dialog = new AlertDialog();
        dialog.setContext(context);
        if (!TextUtils.isEmpty(title)) {
            dialog.setTitle(title);
        }
        if (!TextUtils.isEmpty(message)) {
            dialog.setMessage(message);
        }
        if (listener != null) {
            dialog.setDialogDelegate(listener);
        }
        if (btns != null) {
            dialog.setButtons(btns);
        }
        return dialog;
    }

}
