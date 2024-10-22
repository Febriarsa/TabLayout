package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tablayout.R

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    // Inflate the menu, this adds items to the action bar if it is present.
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_dashboard, menu)
        return true
    }

    // Handle action bar item clicks here
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_profile -> {
                // Open Profile Activity or perform any action you want
                Toast.makeText(this, "Opening Profile...", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_logout -> {
                // Logout logic
                Toast.makeText(this, "Logging out...", Toast.LENGTH_SHORT).show()

                // Optionally, clear session or data and go back to login
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
