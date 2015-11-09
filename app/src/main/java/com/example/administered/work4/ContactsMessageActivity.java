package com.example.administered.work4;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by administered on 2015/11/4.
 */
public class ContactsMessageActivity extends AddConctactsActivity {

    private TextView nameTV,mobileTV,danweiTV,qqTV,addressTV;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        nameTV = (TextView) findViewById(R.id.name);
        mobileTV = (TextView) findViewById(R.id.mobile);
        danweiTV = (TextView) findViewById(R.id.danwei);
        qqTV = (TextView) findViewById(R.id.qq);
        addressTV = (TextView) findViewById(R.id.adress);
        Bundle localBundle = getIntent().getExtras();
        int id = localBundle.getInt("user_ID");
        ContactsTable ct = new ContactsTable(this);
        user = ct.getUserByID(id);
        nameTV.setText("姓名：" + user.getName());
        mobileTV.setText("电话：" + user.getMobile());
        qqTV.setText("QQ：" + user.getQq());
        danweiTV.setText("单位：" + user.getDanwei());
        addressTV.setText("地址：" + user.getAddress());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"返回");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

