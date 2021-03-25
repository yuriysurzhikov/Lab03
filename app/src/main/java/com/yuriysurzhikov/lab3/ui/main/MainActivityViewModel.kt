package com.yuriysurzhikov.lab3.ui.main

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.yuriysurzhikov.lab3.model.DataContact
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    private val mContactsList = mutableListOf<DataContact>()
    private val mContactsObservable = MutableLiveData<List<DataContact>>()

    val isEmpty = ObservableBoolean()

    fun observeContacts(owner: LifecycleOwner, observer: Observer<List<DataContact>>) {
        mContactsObservable.observe(owner, observer)
    }

    fun insertContact(contact: DataContact) {
        CoroutineScope(Dispatchers.IO).launch {
            mContactsList.add(contact)
            isEmpty.set(mContactsList.isEmpty())
            mContactsObservable.postValue(mContactsList)
        }
    }

    fun removeContact(contact: DataContact) {
        CoroutineScope(Dispatchers.IO).launch {
            mContactsList.remove(contact)
            isEmpty.set(mContactsList.isEmpty())
            mContactsObservable.postValue(mContactsList)
        }
    }
}