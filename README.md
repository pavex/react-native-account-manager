# Account manager for React Native

Only one method yet for get all existing account names

```js
AccountManager.getAccountsByType(null)
	.then((accounts) => {
		console.log('accounts=', accounts);
	})
	.catch((error) => {
		console.log(error);
	});
```
