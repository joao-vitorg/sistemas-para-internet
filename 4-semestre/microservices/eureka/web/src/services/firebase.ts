import { initializeApp } from "firebase/app";
import { getMessaging, getToken, onMessage } from "firebase/messaging";

var firebaseConfig = {
	apiKey: "",
	authDomain: "",
	projectId: "",
	storageBucket: "",
	messagingSenderId: "",
	appId: "",
};

initializeApp(firebaseConfig);

const messaging = getMessaging();

export const requestForToken = () => {
	return getToken(messaging, { vapidKey: `` })
		.then((currentToken) => {
			if (currentToken) {
				console.log("current token for client: ", currentToken);
				// Perform any other neccessary action with the token
			} else {
				// Show permission request UI
				console.log("No registration token available. Request permission to generate one.");
			}
		})
		.catch((err) => {
			console.log("An error occurred while retrieving token. ", err);
		});
};

export const onMessageListener = () =>
	new Promise((resolve) => {
		onMessage(messaging, (payload) => {
			resolve(payload);
		});
	});
