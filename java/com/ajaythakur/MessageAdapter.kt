package com.ajaythakur

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.ajaythakur.chatapplication.R
import com.google.firebase.auth.FirebaseAuth
import android.content.Context


class MessageAdapter(val context: Context  , val messageList: ArrayList<Message>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

  val ITEM_RECEIVE = 1;
    val ITEM_SENT = 2;


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ITEM_SENT) {
            val view = LayoutInflater.from(context).inflate(R.layout.sent, parent, false)
            SentViewHolder(view)
        } else {
            val view = LayoutInflater.from(context).inflate(R.layout.receive, parent, false)
            ReceiveViewHolder(view)
        }
    }


    override fun getItemViewType(position: Int): Int {
        val currentMessage = messageList[position]

        return if (FirebaseAuth.getInstance().currentUser?.uid == currentMessage.senderId) {
            ITEM_SENT
        } else {
            ITEM_RECEIVE
        }
    }

    override fun getItemCount(): Int {
    return messageList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMessage = messageList[position]
       if (holder.javaClass == SentViewHolder::class.java){
           // do the stuff for sent view Holder
           val viewHolder = holder as SentViewHolder
           holder.sentMessage.text = currentMessage.message

       }else{
           // do stuff for receive view Holder
           val viewHolder = holder as ReceiveViewHolder
           holder.receievMessage.text = currentMessage.message
       }
    }

    class SentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
   val sentMessage = itemView.findViewById<TextView>(R.id.txt_sent_message)
    }

    class ReceiveViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val receievMessage = itemView.findViewById<TextView>(R.id.txt_receive_message)
    }

}