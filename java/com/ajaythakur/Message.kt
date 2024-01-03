package com.ajaythakur

class Message {

    var message : String? = null
    var senderId : String?= null

    constructor(){}

    constructor(message: String?, senderId: String){
        this.message= message
        this.senderId= senderId
    }

//    constructor(message: String) {
//        this.message = message
//        // You can set a default senderId if needed
//        this.senderId = "defaultSenderId"
//    }
}