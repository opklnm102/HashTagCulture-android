package com.ipocs.hashtagculture.fragment;

import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ipocs.hashtagculture.R;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TalkFragment extends BaseFragment {

    public static final String TAG = TalkFragment.class.getSimpleName();

    private WebSocketClient mWebSocketClient;

    @Bind(R.id.textView_messages)
    TextView tvMessage;

    @Bind(R.id.editText_message)
    EditText etMessage;

    @Bind(R.id.button_send)
    Button btnSend;

    public static TalkFragment newInstance() {
        TalkFragment fragment = new TalkFragment();
        return fragment;
    }

    public TalkFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_talk, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        connectWebSocket();

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

        Log.e("fragment", TAG + " onViewCreated");
    }

    private void connectWebSocket() {
        URI uri;
        try {
            // uri = new URI("ws://websockethost:8080");
            uri = new URI("ws://cultalk.herokuapp.com");

        } catch (URISyntaxException e) {
            e.printStackTrace();
            return;
        }

        mWebSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
                Log.e(TAG, "Opened");
                mWebSocketClient.send("Hello from" + Build.MANUFACTURER + " " + Build.MODEL);
            }

            @Override
            public void onMessage(final String message) {

                Handler handler = new Handler(Looper.getMainLooper());
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvMessage.setText(tvMessage.getText() + "\n" + message);
                    }
                });
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                Log.e(TAG, "onClose " + reason);
            }

            @Override
            public void onError(Exception ex) {
                Log.i(TAG, "onError" + ex.getMessage());
            }
        };
        mWebSocketClient.connect();
    }

    public void sendMessage() {
        mWebSocketClient.send(etMessage.getText().toString());
        etMessage.setText("");
    }


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Log.e("fragment", TAG + " onAttach");
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        Log.e("fragment", TAG +  " onDestroyView");
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        Log.e("fragment", TAG + " onDetach");
//    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        Log.e("fragment", TAG + " onDestroy");
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        Log.e("fragment", TAG + " onResume");
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        Log.e("fragment", TAG + " onPause");
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        Log.e("fragment", TAG + " onPause");
//    }
}
