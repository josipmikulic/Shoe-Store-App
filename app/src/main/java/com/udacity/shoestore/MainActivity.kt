package com.udacity.shoestore

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.appbar.AppBarLayout
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.ui.ShoeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarLayout: AppBarLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var viewModel: ShoeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[ShoeViewModel::class.java]
        appBarLayout = binding.drawerLayout
        val navController = this.findNavController(R.id.myNavHostFragment)
        appBarConfiguration =
            AppBarConfiguration.Builder(R.id.shoeListFragment, R.id.loginFragment).build()
        setSupportActionBar(binding.toolbar)
        binding.toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.menu_logout) {
                navController.navigate(R.id.action_shoeListFragment_to_loginFragment)
            }
            false
        }
        setupActionBarWithNavController(navController, appBarConfiguration)
        navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, bundle: Bundle? ->
            binding.toolbar.menu.findItem(R.id.menu_logout)?.isVisible =
                nd.id == R.id.shoeListFragment
        }
        NavigationUI.setupWithNavController(binding.navView, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.shoe_list_menu, menu)
        binding.toolbar.menu.findItem(R.id.menu_logout).isVisible = false
        return true
    }
}
