export const Avatars = [
	null,
	require("../../../assets/firebase/man.png"),
	require("../../../assets/firebase/woman.png"),
];

const enum Avatar {
	none,
	man,
	woman,
}

export interface User {
	email: string;
	avatar: Avatar;
}

export type userContext = {
	user: User;
	setUser: (user: User) => void;
};
