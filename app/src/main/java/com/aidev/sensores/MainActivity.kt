package com.aidev.sensores

import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var mSensorManager: SensorManager
    private lateinit var mAcelerometro: Sensor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //instacia o sensor manager responsavel por gerenciar os sensores
        mSensorManager = getSystemService(SENSOR_SERVICE) as SensorManager


        mAcelerometro = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)


    }

    override fun onResume() {
        super.onResume()
        mSensorManager.registerListener(this, mAcelerometro, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onPause() {
        super.onPause()
        mSensorManager.unregisterListener(this)
    }


    override fun onSensorChanged(p0: SensorEvent) {

        var X = p0.values[0]
        var Y = p0.values[1]
        var Z = p0.values[2]

        tvValorX.text = X.toString()
        tvValorY.text = Y.toString()
        tvValorZ.text = Z.toString()


    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }

    fun btMeusSensoresOnClick(view: View) {

        var list: List<Sensor> = mSensorManager.getSensorList(Sensor.TYPE_ALL)
        var lista: ArrayList<String> = ArrayList()

        list.forEach {
            lista.add(it.name)
        }


        var intent = Intent(this, ListarActivity::class.java)
        intent.putExtra("sensores",lista)
        startActivity(intent)


    }
}