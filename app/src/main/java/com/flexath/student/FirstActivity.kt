package com.flexath.student

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_first.*
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class FirstActivity : AppCompatActivity() {

    private var userInfoList = ArrayList<StudentIdentity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        val rollNumber = intent.getIntExtra("Roll",0)
        val imageId = intent.getIntExtra("Image",0)
//
//        roll.text = rollNumber.toString()
//        name.text = nameText.toString()
        imageAth.setImageResource(imageId)

        val obj = JSONObject(jsonFromAssets()!!)
        val objArray = obj.getJSONArray("students")

        for(i in 0 until objArray.length()){
            val user = objArray.getJSONObject(i)

            val rollJson = user.getInt("roll")
            val nameJson = user.getString("name")
            val genderJson = user.getString("gender")
            val emailJson = user.getString("email")
            val mobileJson = user.getString("mobile")
            val weightJson = user.getInt("weight")
            val heightJson = user.getDouble("height")

            val userDetails = StudentIdentity(rollJson,nameJson,genderJson,emailJson,mobileJson,weightJson,heightJson)
            userInfoList.add(userDetails)
        }
        displayStudentInfo(rollNumber)
    }

    private fun displayStudentInfo(rollNo:Int) {
        when(rollNo) {
            14 -> {
                roll.text = userInfoList[0].studentRoll.toString()
                name.text = userInfoList[0].studentName
                gender.text = userInfoList[0].studentGender
                email.text = userInfoList[0].studentEmail
                mobile.text = userInfoList[0].studentMobile
                weight.text = userInfoList[0].studentWeight.toString()
                height.text = userInfoList[0].studentHeight.toString()
            }
            9 -> {
                roll.text = userInfoList[1].studentRoll.toString()
                name.text = userInfoList[1].studentName
                gender.text = userInfoList[1].studentGender
                email.text = userInfoList[1].studentEmail
                mobile.text = userInfoList[1].studentMobile
                weight.text = userInfoList[1].studentWeight.toString()
                height.text = userInfoList[1].studentHeight.toString()
            }
            6 -> {
                roll.text = userInfoList[2].studentRoll.toString()
                name.text = userInfoList[2].studentName
                gender.text = userInfoList[2].studentGender
                email.text = userInfoList[2].studentEmail
                mobile.text = userInfoList[2].studentMobile
                weight.text = userInfoList[2].studentWeight.toString()
                height.text = userInfoList[2].studentHeight.toString()
            }
            5 -> {
                roll.text = userInfoList[3].studentRoll.toString()
                name.text = userInfoList[3].studentName
                gender.text = userInfoList[3].studentGender
                email.text = userInfoList[3].studentEmail
                mobile.text = userInfoList[3].studentMobile
                weight.text = userInfoList[3].studentWeight.toString()
                height.text = userInfoList[3].studentHeight.toString()
            }
            12 -> {
                roll.text = userInfoList[4].studentRoll.toString()
                name.text = userInfoList[4].studentName
                gender.text = userInfoList[4].studentGender
                email.text = userInfoList[4].studentEmail
                mobile.text = userInfoList[4].studentMobile
                weight.text = userInfoList[4].studentWeight.toString()
                height.text = userInfoList[4].studentHeight.toString()
            }
            7 -> {
                roll.text = userInfoList[5].studentRoll.toString()
                name.text = userInfoList[5].studentName
                gender.text = userInfoList[5].studentGender
                email.text = userInfoList[5].studentEmail
                mobile.text = userInfoList[5].studentMobile
                weight.text = userInfoList[5].studentWeight.toString()
                height.text = userInfoList[5].studentHeight.toString()
            }
            1 -> {
                roll.text = userInfoList[6].studentRoll.toString()
                name.text = userInfoList[6].studentName
                gender.text = userInfoList[6].studentGender
                email.text = userInfoList[6].studentEmail
                mobile.text = userInfoList[6].studentMobile
                weight.text = userInfoList[6].studentWeight.toString()
                height.text = userInfoList[6].studentHeight.toString()
            }
        }
    }

    private fun jsonFromAssets() : String? {
        val json: String?
        val charset:Charset = Charsets.UTF_8
        try{
            val jsonFile = assets.open("studentInfo.json")
            val size = jsonFile.available()
            val buffer = ByteArray(size)
            jsonFile.read(buffer)
            jsonFile.close()
            json = String(buffer,charset)
        }catch(ex:IOException){
            ex.printStackTrace()
            return null
        }

        return json
    }
}