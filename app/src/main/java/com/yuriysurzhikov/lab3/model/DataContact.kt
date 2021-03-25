package com.yuriysurzhikov.lab3.model

import android.net.Uri

data class DataContact(
    var name: String?,
    var email: String?,
    var phone: String?,
    var imageProfile: Uri?
)