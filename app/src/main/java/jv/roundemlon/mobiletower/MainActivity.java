package jv.roundemlon.mobiletower;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textGsmCellLocation = (TextView)findViewById(R.id.gsmcelllocation);
        TextView textCID = (TextView)findViewById(R.id.cid);
        TextView textLAC = (TextView)findViewById(R.id.lac);



        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
//        try{
        GsmCellLocation cellLocation = (GsmCellLocation)telephonyManager.getCellLocation();
//        }catch (Exception e){
//            Log.d("Debud","Error");
//        }

        int cid = cellLocation.getCid();
        int lac = cellLocation.getLac();
        textGsmCellLocation.setText(cellLocation.toString());
        textCID.setText("gsm cell id: " + String.valueOf(cid));
        textLAC.setText("gsm location area code: " + String.valueOf(lac));


        Log.d("CellLocation", cellLocation.toString());
        Log.d("GSM CELL ID",  String.valueOf(cid));
        Log.d("GSM Location Code", String.valueOf(lac));
    }
}
