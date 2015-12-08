package br.ufc.great.iot.syssumonitor;

import android.content.Context;

import java.io.IOException;

import br.ufc.great.syssu.base.Pattern;
import br.ufc.great.syssu.base.Provider;
import br.ufc.great.syssu.base.Tuple;
import br.ufc.great.syssu.base.TupleSpaceException;
import br.ufc.great.syssu.base.TupleSpaceSecurityException;
import br.ufc.great.syssu.base.interfaces.IReaction;
import br.ufc.great.syssu.ubibroker.GenericDomain;
import br.ufc.great.syssu.ubibroker.GenericUbiBroker;
import br.ufc.great.syssu.ubicentre.UbiCentreProcess;

/**
 * Created by Felipe on 07/12/2015.
 */
public class SyssuManager {

    private static SyssuManager instance;

    private Context context;

    private GenericDomain mDomain;
    private static final int LOCAL_PORT = 9090;

    private SyssuManager(Context context){
        this.context = context;
    }

    public static SyssuManager getInstance(Context context){
        if(instance == null){
            instance = new SyssuManager(context);
        }
        return instance;
    }

    public void start(){
        startUbiCentre();

        try {
            GenericUbiBroker ubiBroker = GenericUbiBroker.createUbibroker(context);
            mDomain = (GenericDomain) ubiBroker.getDomain("GREAT");
        } catch (IOException e) {
            System.exit(1);
        } catch (TupleSpaceException e) {
            System.exit(1);
        }
    }

    private void startUbiCentre() {
        //start Ubicentre
        try {
            Thread t = new Thread(new UbiCentreProcess(LOCAL_PORT), "UbiCentre Process");
            t.start();
        } catch (Exception ex) {
            System.exit(1);
        }
    }

    public void put (Tuple tuple){
        try {
            mDomain.put(tuple, Provider.ADHOC);
        } catch (TupleSpaceException e) {
            e.printStackTrace();
        } catch (TupleSpaceSecurityException e) {
            e.printStackTrace();
        }
    }

    public Object subscribe (IReaction reaction){
        try {
            return mDomain.subscribe(reaction, "put", "", Provider.ADHOC);
        } catch (TupleSpaceException e) {
            e.printStackTrace();
        } catch (TupleSpaceSecurityException e) {
            e.printStackTrace();
        }

        return "error";
    }

    public void unsubscribe(Object id){
        try {
            mDomain.unsubscribe(id, "");
        } catch (TupleSpaceException e) {
            e.printStackTrace();
        } catch (TupleSpaceSecurityException e) {
            e.printStackTrace();
        }
    }

    public void read(Pattern pattern){
        try {
            mDomain.read(pattern, "", null, Provider.ADHOC);
        } catch (TupleSpaceException e) {
            e.printStackTrace();
        } catch (TupleSpaceSecurityException e) {
            e.printStackTrace();
        }
    }
}
