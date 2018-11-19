package com.saraakhtar.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageListActivity extends AppCompatActivity {
    private RecyclerView mMessageRecycler;
    private MessageListAdapter mMessageAdapter;
    final SimpleDateFormat dateFormat = new SimpleDateFormat("KK:mm:ss a");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow);

        mMessageRecycler = findViewById(R.id.reyclerview_message_list);
        final List<BaseMessage> messageList = new ArrayList<>();
        messageList.add(new BaseMessage("Sara", "Me", "when will you be here?",
                dateFormat.format(new Date())));

        mMessageAdapter = new MessageListAdapter(this, messageList);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMessageRecycler.setAdapter(mMessageAdapter);

        final EditText mMessageText = findViewById(R.id.edittext_chatbox);
        Button mSendButton = findViewById(R.id.button_chatbox_send);
        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager inputManager =
                        (InputMethodManager) view.getContext().
                                getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(
                        MessageListActivity.this.getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                mMessageText.setText("");

                String messageText = mMessageText.getText().toString();
                BaseMessage message = new BaseMessage("Me", "shivangi",
                        messageText,dateFormat.format(new Date()));
                messageList.add(message);
                mMessageAdapter.notifyDataSetChanged();


                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",messageText);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}