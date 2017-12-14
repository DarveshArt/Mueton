package com.darveshart.app.friend;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView mMessageRecycler;

    private MessageListAdapter mMessageAdapter;
    private List<BaseMessage> mMessageList;
    private Button button;
    private EditText editText;
    private BaseMessage userMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        BaseMessage baseMessage = new BaseMessage();
        baseMessage.setMessage("Hi");
        //sentMessage = new BaseMessage();
        mMessageList = new ArrayList<>();
        mMessageList.add(baseMessage);
        button = findViewById(R.id.button_chatbox_send);
        editText = findViewById(R.id.edittext_chatbox);


        mMessageRecycler =  findViewById(R.id.reyclerview_message_list);
        mMessageAdapter = new MessageListAdapter(mMessageList, this);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMessageRecycler.setItemAnimator(new DefaultItemAnimator());
        mMessageRecycler.setAdapter(mMessageAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals("")) {
                    func();
                }
            }
        });
        editText.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    button.performClick();
                    return true;
                }
                if (actionId == KeyEvent.KEYCODE_ENTER) {
                    button.performClick();
                    return true;
                }
                return false;
            }
        });
        handler = new Handler();
        friend = new Friend();

    }
    private Handler handler;
    private Friend friend;
    public  void  func(){
        BaseMessage setMes = new BaseMessage();
        setMes.setMessage(editText.getText().toString());
        friend.setUserMessage(setMes.getMessage());
        editText.setText("");
        mMessageList.add(setMes);
        mMessageRecycler.setAdapter(mMessageAdapter);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                BaseMessage setMes2 = new BaseMessage();
                setMes2.setMessage(friend.getMyMessage());
                mMessageList.add(setMes2);
                mMessageRecycler.setAdapter(mMessageAdapter);
            }
        },2500);

    }

}
