/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\Android\\git\\SysSU-Monitor\\usable\\src\\main\\aidl\\br\\ufc\\great\\somc\\network\\base\\WifiDirectListener.aidl
 */
package br.ufc.great.somc.network.base;
public interface WifiDirectListener extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements br.ufc.great.somc.network.base.WifiDirectListener
{
private static final java.lang.String DESCRIPTOR = "br.ufc.great.somc.network.base.WifiDirectListener";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an br.ufc.great.somc.network.base.WifiDirectListener interface,
 * generating a proxy if needed.
 */
public static br.ufc.great.somc.network.base.WifiDirectListener asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof br.ufc.great.somc.network.base.WifiDirectListener))) {
return ((br.ufc.great.somc.network.base.WifiDirectListener)iin);
}
return new br.ufc.great.somc.network.base.WifiDirectListener.Stub.Proxy(obj);
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
case TRANSACTION_onStateConnectionChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.onStateConnectionChanged(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onDeviceFound:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
this.onDeviceFound(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onDeviceConnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.onDeviceConnect(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onDeviceDisconnect:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
this.onDeviceDisconnect(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_onMessageReceived:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onMessageReceived(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onExceptionOccurred:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
this.onExceptionOccurred(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_onWifiStateChanged:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.onWifiStateChanged(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onConnectionInfo:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.onConnectionInfo(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements br.ufc.great.somc.network.base.WifiDirectListener
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
@Override public void onStateConnectionChanged(int state, int previousState) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(state);
_data.writeInt(previousState);
mRemote.transact(Stub.TRANSACTION_onStateConnectionChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onDeviceFound(java.lang.String name, java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(name);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_onDeviceFound, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onDeviceConnect(java.lang.String uuid, java.lang.String name, java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(uuid);
_data.writeString(name);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_onDeviceConnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onDeviceDisconnect(java.lang.String uuid, java.lang.String name, java.lang.String address) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(uuid);
_data.writeString(name);
_data.writeString(address);
mRemote.transact(Stub.TRANSACTION_onDeviceDisconnect, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onMessageReceived(java.lang.String jsonMessage) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(jsonMessage);
mRemote.transact(Stub.TRANSACTION_onMessageReceived, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onExceptionOccurred(int code, java.lang.String message) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(code);
_data.writeString(message);
mRemote.transact(Stub.TRANSACTION_onExceptionOccurred, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onWifiStateChanged(int state) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(state);
mRemote.transact(Stub.TRANSACTION_onWifiStateChanged, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void onConnectionInfo(java.lang.String groupInfo) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(groupInfo);
mRemote.transact(Stub.TRANSACTION_onConnectionInfo, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_onStateConnectionChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_onDeviceFound = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_onDeviceConnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_onDeviceDisconnect = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_onMessageReceived = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_onExceptionOccurred = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_onWifiStateChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_onConnectionInfo = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
}
public void onStateConnectionChanged(int state, int previousState) throws android.os.RemoteException;
public void onDeviceFound(java.lang.String name, java.lang.String address) throws android.os.RemoteException;
public void onDeviceConnect(java.lang.String uuid, java.lang.String name, java.lang.String address) throws android.os.RemoteException;
public void onDeviceDisconnect(java.lang.String uuid, java.lang.String name, java.lang.String address) throws android.os.RemoteException;
public void onMessageReceived(java.lang.String jsonMessage) throws android.os.RemoteException;
public void onExceptionOccurred(int code, java.lang.String message) throws android.os.RemoteException;
public void onWifiStateChanged(int state) throws android.os.RemoteException;
public void onConnectionInfo(java.lang.String groupInfo) throws android.os.RemoteException;
}
