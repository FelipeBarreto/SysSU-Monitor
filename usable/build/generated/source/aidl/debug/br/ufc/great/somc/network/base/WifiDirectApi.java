/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: C:\\Users\\GREAT\\GREat Projects\\networklayer\\app\\src\\main\\aidl\\br\\ufc\\great\\somc\\network\\base\\WifiDirectApi.aidl
 */
package br.ufc.great.somc.network.base;
public interface WifiDirectApi extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements br.ufc.great.somc.network.base.WifiDirectApi
{
private static final java.lang.String DESCRIPTOR = "br.ufc.great.somc.network.base.WifiDirectApi";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an br.ufc.great.somc.network.base.WifiDirectApi interface,
 * generating a proxy if needed.
 */
public static br.ufc.great.somc.network.base.WifiDirectApi asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof br.ufc.great.somc.network.base.WifiDirectApi))) {
return ((br.ufc.great.somc.network.base.WifiDirectApi)iin);
}
return new br.ufc.great.somc.network.base.WifiDirectApi.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_addListener:
{
data.enforceInterface(DESCRIPTOR);
br.ufc.great.somc.network.base.WifiDirectListener _arg0;
_arg0 = br.ufc.great.somc.network.base.WifiDirectListener.Stub.asInterface(data.readStrongBinder());
this.addListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_removeListener:
{
data.enforceInterface(DESCRIPTOR);
br.ufc.great.somc.network.base.WifiDirectListener _arg0;
_arg0 = br.ufc.great.somc.network.base.WifiDirectListener.Stub.asInterface(data.readStrongBinder());
this.removeListener(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_sendBroadcastMessage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.sendBroadcastMessage(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_sendUnicastMessage:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.sendUnicastMessage(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_startDiscovery:
{
data.enforceInterface(DESCRIPTOR);
this.startDiscovery();
reply.writeNoException();
return true;
}
case TRANSACTION_createGroup:
{
data.enforceInterface(DESCRIPTOR);
this.createGroup();
reply.writeNoException();
return true;
}
case TRANSACTION_removeGroup:
{
data.enforceInterface(DESCRIPTOR);
this.removeGroup();
reply.writeNoException();
return true;
}
case TRANSACTION_requestGroupIno:
{
data.enforceInterface(DESCRIPTOR);
this.requestGroupIno();
reply.writeNoException();
return true;
}
case TRANSACTION_manualConnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.manualConnect(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_getCurrentState:
{
data.enforceInterface(DESCRIPTOR);
int _result = this.getCurrentState();
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_getNeighborhood:
{
data.enforceInterface(DESCRIPTOR);
java.util.List<java.lang.String> _result = this.getNeighborhood();
reply.writeNoException();
reply.writeStringList(_result);
return true;
}
case TRANSACTION_getMyAddress:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getMyAddress();
reply.writeNoException();
reply.writeString(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements br.ufc.great.somc.network.base.WifiDirectApi
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void addListener(br.ufc.great.somc.network.base.WifiDirectListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_addListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void removeListener(br.ufc.great.somc.network.base.WifiDirectListener listener) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((listener!=null))?(listener.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_removeListener, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void sendBroadcastMessage(java.lang.String jsonMessage, java.lang.String avoidAddress) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(jsonMessage);
_data.writeString(avoidAddress);
mRemote.transact(Stub.TRANSACTION_sendBroadcastMessage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void sendUnicastMessage(java.lang.String jsonMessage, java.lang.String destinationAddress) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(jsonMessage);
_data.writeString(destinationAddress);
mRemote.transact(Stub.TRANSACTION_sendUnicastMessage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void startDiscovery() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_startDiscovery, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void createGroup() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_createGroup, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void removeGroup() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_removeGroup, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void requestGroupIno() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_requestGroupIno, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void manualConnect(java.lang.String deviceAddress) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(deviceAddress);
mRemote.transact(Stub.TRANSACTION_manualConnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public int getCurrentState() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getCurrentState, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.util.List<java.lang.String> getNeighborhood() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<java.lang.String> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getNeighborhood, _data, _reply, 0);
_reply.readException();
_result = _reply.createStringArrayList();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String getMyAddress() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getMyAddress, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_addListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_removeListener = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_sendBroadcastMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_sendUnicastMessage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_startDiscovery = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_createGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_removeGroup = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_requestGroupIno = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_manualConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_getCurrentState = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_getNeighborhood = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_getMyAddress = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
}
public void addListener(br.ufc.great.somc.network.base.WifiDirectListener listener) throws android.os.RemoteException;
public void removeListener(br.ufc.great.somc.network.base.WifiDirectListener listener) throws android.os.RemoteException;
public void sendBroadcastMessage(java.lang.String jsonMessage, java.lang.String avoidAddress) throws android.os.RemoteException;
public void sendUnicastMessage(java.lang.String jsonMessage, java.lang.String destinationAddress) throws android.os.RemoteException;
public void startDiscovery() throws android.os.RemoteException;
public void createGroup() throws android.os.RemoteException;
public void removeGroup() throws android.os.RemoteException;
public void requestGroupIno() throws android.os.RemoteException;
public void manualConnect(java.lang.String deviceAddress) throws android.os.RemoteException;
public int getCurrentState() throws android.os.RemoteException;
public java.util.List<java.lang.String> getNeighborhood() throws android.os.RemoteException;
public java.lang.String getMyAddress() throws android.os.RemoteException;
}
