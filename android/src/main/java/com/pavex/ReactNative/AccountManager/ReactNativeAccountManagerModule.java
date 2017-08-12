/**
 * @author Pavex <pavex@ines.cz>
 */
package com.pavex.ReactNative.AccountManager;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

import android.content.Context;
import android.accounts.Account;
import android.accounts.AccountManager;



/**
 */
public class ReactNativeAccountManagerModule extends ReactContextBaseJavaModule {


	public ReactNativeAccountManagerModule(ReactApplicationContext reactContext) {
		super(reactContext);
	}





	@Override
	public String getName() {
		return "ReactNativeAccountManager";
	}





	@ReactMethod
	public void getAccountsByType(String accountType, Promise promise) {
		AccountManager manager = (AccountManager) getReactApplicationContext().getSystemService(Context.ACCOUNT_SERVICE);		
		WritableArray accounts = Arguments.createArray();
		for (Account account: manager.getAccountsByType(accountType)) {
			WritableMap map = Arguments.createMap();
			map.putString("name", account.name);
			map.putString("type", account.type);
			accounts.pushMap(map);
		}
		promise.resolve(accounts);
	}





}
