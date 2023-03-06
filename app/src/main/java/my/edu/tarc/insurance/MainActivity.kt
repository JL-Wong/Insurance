package my.edu.tarc.insurance

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.edu.tarc.insurance.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalculate.setOnClickListener{
            var premium: Int = 0
            var extra: Int = 0
//            var smoke: Int = 0
            var total: Int = 0
            //read age group by check what item been select in the spinner
            //position start from 0 to n-1
            val age = binding.spinnerAge.selectedItemPosition
            when (age) {
                0 -> {
                    //less than 17
                    premium = 60
                }
                1 -> {
                    premium = 70
                }
                2 -> {
                    premium = 90
                }
                3 -> {
                    premium = 120
                }
                4 -> {
                    premium = 150
                }
                5 -> {
                    premium = 150
                }
            }
            val smoker = binding.checkBoxSmoker.isChecked
            val gender = binding.radioGroupGender.checkedRadioButtonId//to get the id of which radio button been selected
            if(gender == binding.radioButtonMale.id){
                //cal extra premium for male
                when (age) {
                    1 -> {
                        if(smoker) {
                            extra = 150
                        }else{
                            extra = 50
                        }
                    }
                    2 -> {
                        if(smoker) {
                            extra = 250
                        }else{
                            extra = 100
                        }
                    }
                    3 -> {
                        if(smoker) {
                            extra = 350
                        }else{
                            extra = 150
                        }
                    }
                    4 -> {
                        if(smoker) {
                            extra = 450
                        }else{
                            extra = 200
                        }
                    }
                    5 -> {
                        if(smoker) {
                            extra = 500
                        }else{
                            extra = 200
                        }
                    }
                }
            }


            total = premium + extra
            binding.myPremium = Premium(premium, extra, total)//display output
        }

        binding.buttonReset.setOnClickListener {
            var premium: Int = 0
            var extra: Int = 0
            var total: Int = 0
            binding.myPremium = Premium(premium, extra, total)
            binding.checkBoxSmoker.isChecked = false
            binding.radioButtonMale.isChecked = false
            binding.radioButtonFemale.isChecked = false
            binding.spinnerAge.setSelection(0)

        }
    }
}