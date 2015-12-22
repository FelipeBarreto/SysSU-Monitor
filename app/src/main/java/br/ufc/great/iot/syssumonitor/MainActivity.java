package br.ufc.great.iot.syssumonitor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import br.ufc.great.syssu.base.Pattern;
import br.ufc.great.syssu.base.Provider;
import br.ufc.great.syssu.base.Tuple;
import br.ufc.great.syssu.base.TupleSpaceException;
import br.ufc.great.syssu.base.interfaces.IReaction;
import br.ufc.great.syssu.net.AdhocNetworkManager;
import br.ufc.great.syssu.ubibroker.GenericDomain;
import br.ufc.great.syssu.ubibroker.GenericUbiBroker;
import br.ufc.great.syssu.ubicentre.UbiCentreProcess;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvUsers;

    private ListUsersAdapter mAdapter;

    private ArrayList<String> mUsers;

    private SyssuManager mSyssu;

    private String myId = "Device B";
    private boolean running = false;
    private Object subscribeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSyssu = SyssuManager.getInstance(this);

        rvUsers = (RecyclerView) findViewById(R.id.rv_users);
        rvUsers.setHasFixedSize(false);

        rvUsers.setLayoutManager(new LinearLayoutManager(this));

        mUsers = new ArrayList<String>();

        mAdapter = new ListUsersAdapter(mUsers);
        rvUsers.setAdapter(mAdapter);

        rvUsers.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }
                })
        );

        mSyssu.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                running = true;
                Tuple t = (Tuple) new Tuple().addField("ContextKey", "context.device.id")
                                            .addField("DeviceId", myId);
                while(running){
                    mSyssu.put(t, Provider.ADHOC);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        IReaction reaction = new IReaction() {

            private Object id;

            @Override
            public void setId(Object id) {
                this.id = id;
            }

            @Override
            public Object getId() {
                return id;
            }

            @Override
            public Pattern getPattern() {
                Pattern p = (Pattern) new Pattern().addField("ContextKey", "context.device.id");
                return p;
            }

            @Override
            public String getRestriction() {
                return null;
            }

            @Override
            public void react(Tuple tuple) {
                String id = tuple.getField(1).getValue().toString();

                if(myId.equals(id)){
                    return;
                }

                if(!mUsers.contains(id)){
                    mUsers.add(id);
                    mAdapter.setmDataset(mUsers);
                    mAdapter.notifyDataSetChanged();
                }
            }
        };

        subscribeId = mSyssu.subscribe(reaction, Provider.LOCAL);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mSyssu.unsubscribe(subscribeId);
        running = false;
    }
}
