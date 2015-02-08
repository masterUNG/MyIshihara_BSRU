package appewtc.masterung.myishihara;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by masterUNG on 2/8/15 AD.
 */
public class MyAlertDialog {

    private AlertDialog.Builder objAlert;


    public void answer(Context context) {

        objAlert = new AlertDialog.Builder(context);
        objAlert.setIcon(R.drawable.danger);
        objAlert.setTitle("กรุณาตอบคำถาม");
        objAlert.setMessage("กรุณาตอบคำถาม เว้ยเห้ย");
        objAlert.setCancelable(false);
        objAlert.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        objAlert.show();


    }

}   // Main class
