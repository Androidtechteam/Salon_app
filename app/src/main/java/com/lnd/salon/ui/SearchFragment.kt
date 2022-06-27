package com.lnd.salon.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.lnd.salon.adapter.FinalResultAdapter
import com.lnd.salon.adapter.PopularArtistListAdapter
import com.lnd.salon.adapter.SalonServiceAdapter
import com.lnd.salon.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    lateinit var binding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(layoutInflater)

        loadSalonService()

        return binding.root
    }

    private fun loadSalonService() {
        val myNameList =
            arrayOf("All", "Haircuts", "Makeup", "massage", "Skin care")
        val salonServiceAdapter = SalonServiceAdapter(requireContext(),myNameList,object : SalonServiceAdapter.ItemClickListener{
            override fun onItemClick(view: View?, position: Int) {
                populateArtist()

                loadBottomList()
            }
        })
        binding.rvList.adapter = salonServiceAdapter
        binding.rvList.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)


    }

    private fun loadBottomList() {
        val myNameList =
            arrayOf("Jack", "Jennifer", "Juliet", "Lilly", "Lee")
        val finalResultAdapter = FinalResultAdapter(requireContext(),myNameList,object : FinalResultAdapter.ItemClickListener{
            override fun onItemClick(view: View?, position: Int) {

            }

        })
        binding.rvFindResult.adapter = finalResultAdapter
        binding.rvFindResult.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
    }

    private fun populateArtist() {
        val myNameList =
            arrayOf("Jack", "Jennifer", "Juliet", "Lilly", "Lee")
        val popularArtistListAdapter = PopularArtistListAdapter(requireContext(),myNameList,object : PopularArtistListAdapter.ItemClickListener{
            override fun onItemClick(view: View?, position: Int) {

            }

        })
        binding.rvPopularList.adapter = popularArtistListAdapter
        binding.rvPopularList.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)

    }

}