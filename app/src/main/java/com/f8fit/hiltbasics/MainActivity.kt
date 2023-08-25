package com.f8fit.hiltbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.f8fit.hiltbasics.bad.TasksBad
import com.f8fit.hiltbasics.databinding.ActivityMainBinding
import com.f8fit.hiltbasics.di.TasksDI
import com.f8fit.hiltbasics.manual.Database
import com.f8fit.hiltbasics.manual.DiProvider
import com.f8fit.hiltbasics.manual.Tasks
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //private lateinit var tasks: Tasks
    //private lateinit var database: Database
    //DI
    @Inject lateinit var tasks: TasksDI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //bad()
        //manual()
        di()
    }

    private fun bad() {
        // val computer = Computer()
        // val database = DatabaseBad()
        // val computer = database.getComputer()
        val tasks = TasksBad()
        updateUI(tasks.getBattery())

        with(binding){
            cpOnOff.setOnCheckedChangeListener { button, isChecked ->
                updateUI(tasks.turnOnOff(isChecked))
            }
            btnVideo.setOnClickListener{ updateUI(tasks.playVideo()) }
            btnMusic.setOnClickListener { updateUI(tasks.playMusic()) }
            btnDev.setOnClickListener { updateUI(tasks.dev()) }
        }
    }

    private fun manual() {
        //database = Database()
        //tasks = Tasks(database)
        //tasks.database = database
        //tasks = DiProvider.tasks()
        updateUI(tasks.getBattery())

        setupClicks()
    }

    private fun di() {
        updateUI(tasks.getBattery())
        setupClicks()
    }

    private fun setupClicks(){
        with(binding){
            cpOnOff.setOnCheckedChangeListener { button, isChecked ->
                updateUI(tasks.turnOnOff(isChecked))
            }
            btnVideo.setOnClickListener{ updateUI(tasks.playVideo()) }
            btnMusic.setOnClickListener { updateUI(tasks.playMusic()) }
            btnDev.setOnClickListener { updateUI(tasks.dev()) }
        }
    }


    private  fun updateUI(batteryLife: Int){
        binding.tvBattery.text = "${batteryLife}hrs"
    }
}