package com.projects.haxor.connector.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.VpnService;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.projects.haxor.connector.R;

public class MainActivity extends Activity {

    private Button buttonTestRoute;
    private Button buttonTestVpnConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.buttonTestRoute = (Button) this.findViewById(R.id.buttonTestRoute);
        this.buttonTestVpnConnection = (Button) this.findViewById(R.id.buttonTestVpnConnection);

        VpnService.prepare(this);



    }

    public void launchTraceActivity(View v){
        System.out.println("Test trace activity");
        Intent intent = new Intent(MainActivity.this, TraceActivity.class);
        startActivity(intent);
    }

    public void launchTestVpnActivity(View v){
        System.out.println("Test VPN");
        Intent intent = new Intent(MainActivity.this, TestVpnActivity.class);
        startActivity(intent);
    }

    public void launchLookupIpActivity(View v){
        System.out.println("Lookup Ip details");

    }

}
