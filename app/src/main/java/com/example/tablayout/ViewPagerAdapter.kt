import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapp.LoginFragment
import com.example.myapp.RegisterFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LoginFragment()  // Fragment pertama
            1 -> RegisterFragment()  // Fragment kedua
            else -> throw IllegalStateException("Invalid position")
        }
    }

    override fun getItemCount(): Int {
        return 2 // Jumlah fragment (Login dan Register)
    }
}
