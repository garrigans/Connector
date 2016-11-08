package com.projects.haxor.connector.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.VpnService;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.projects.haxor.connector.R;
import com.projects.haxor.connector.network.ConnectorVpnService;

public class TestVpnActivity extends Activity implements View.OnClickListener {
    private TextView mServerAddress;
    private TextView mServerPort;
    private TextView mSharedSecret;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_vpn);

        mServerAddress = (TextView) findViewById(R.id.address);
        mServerPort = (TextView) findViewById(R.id.port);
        mSharedSecret = (TextView) findViewById(R.id.secret);

        findViewById(R.id.connect).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        System.out.println("Attempting to run, recieved click");
        Intent intent = VpnService.prepare(this);
        if (intent != null) {
            startActivityForResult(intent, 0);
        } else {
            onActivityResult(0, RESULT_OK, null);
        }
    }

    @Override
    protected void onActivityResult(int request, int result, Intent data) {
        System.out.println("Hitting activity result.");
        if (result == RESULT_OK) {
            System.out.println("Trying connection");
            String prefix = getPackageName();
            Intent intent = new Intent(this, ConnectorVpnService.class)
                    .putExtra(prefix + ".ADDRESS", mServerAddress.getText().toString())
                    .putExtra(prefix + ".PORT", mServerPort.getText().toString())
                    .putExtra(prefix + ".SECRET", mSharedSecret.getText().toString());
            startService(intent);
        }
    }
}