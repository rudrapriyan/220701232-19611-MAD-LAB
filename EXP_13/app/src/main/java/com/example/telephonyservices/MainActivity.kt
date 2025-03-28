package com.example.telephonyservices

import android.content.pm.PackageManager
import android.os.Bundle
import android.telephony.TelephonyManager
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val REQUEST_PERMISSION_CODE = 101
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.READ_PHONE_STATE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_PHONE_STATE),REQUEST_PERMISSION_CODE)
        }

        val etNetOp:EditText = findViewById(R.id.etNetOp)
        val etISO:EditText = findViewById(R.id.etISO)
        val etPhoneType:EditText = findViewById(R.id.etPhoneType)
        val etSIM:EditText = findViewById(R.id.etSIM)
        val etNetworkType:EditText = findViewById(R.id.etNetworkType)
        val btServices:Button = findViewById(R.id.btServices)

        val telephonyManager = getSystemService(TELEPHONY_SERVICE) as TelephonyManager

        btServices.setOnClickListener {
            etNetOp.setText(telephonyManager.networkOperatorName)
            etISO.setText(telephonyManager.networkCountryIso)
            val PhoneType = when(telephonyManager.phoneType){
                TelephonyManager.PHONE_TYPE_GSM->"GSM"
                TelephonyManager.PHONE_TYPE_CDMA->"CDMA"
                else ->"Others"
            }
            etPhoneType.setText(PhoneType)

            val simState = when(telephonyManager.simState){
                TelephonyManager.SIM_STATE_READY ->"Ready"
                TelephonyManager.SIM_STATE_ABSENT->"Absent"
                else ->"Others"
            }
            etSIM.setText(simState)

            val networkType = when(telephonyManager.networkType){
                TelephonyManager.NETWORK_TYPE_LTE
->"LTE"
                TelephonyManager.NETWORK_TYPE_NR->"5G"
                else ->"Others"
            }
            etNetworkType.setText(networkType)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}