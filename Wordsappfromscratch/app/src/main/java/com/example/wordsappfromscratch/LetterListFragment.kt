package com.example.wordsappfromscratch
import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsappfromscratch.databinding.FragmentLetterListBinding

class LetterListFragment : Fragment() {
    private var _binding: FragmentLetterListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private var layout = "Linear"

    //Here we are just instantiating the fragment.
    //It is not yet visible as a view
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLetterListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        chooseLayout()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu,menu)
        val layoutButton = menu.findItem(R.id.menu_bar)
        setIcon(layoutButton)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun chooseLayout(){
        if(layout == "Linear"){
            //Fragments are not a context, hence we can't use this
                // However fragments have a context object that we can use
            recyclerView.layoutManager = LinearLayoutManager(context)
        }
        else if(layout == "Grid"){
            recyclerView.layoutManager = GridLayoutManager(context,4)
        }
        recyclerView.adapter = LetterAdapter()
    }
    private fun setIcon(menuItem: MenuItem?){
        if(menuItem == null){
            return
        }
        menuItem.icon = if(layout == "Linear") ContextCompat.getDrawable(this.requireContext(),R.drawable.ic_list)
        else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_bar -> {
                if(layout == "Linear") {layout = "Grid"}
                else {layout = "Linear"}
                chooseLayout()
                setIcon(item)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}